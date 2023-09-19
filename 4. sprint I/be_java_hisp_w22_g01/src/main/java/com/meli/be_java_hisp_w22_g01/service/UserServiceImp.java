package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.ProductDto;
import com.meli.be_java_hisp_w22_g01.dto.response.*;
import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
import com.meli.be_java_hisp_w22_g01.repository.IPostRepository;
import com.meli.be_java_hisp_w22_g01.repository.ISellerRepository;
import com.meli.be_java_hisp_w22_g01.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements IUserService{

    private final IUserRepository userRepository;
    private final ISellerRepository sellerRepository;
    private final ObjectMapper mapper;
    private final IPostRepository postRepository;

    @Override
    public FollowedDTO getUserFollowedList(int user_id) {
        User usersById = userRepository.findById(user_id);
        String userName = usersById.getUser_name();
        List<Seller> followed = usersById.getFollowed();
        List<UserMiniDTO> userMiniDTOS = new ArrayList<>();
        followed.forEach(seller -> userMiniDTOS.add(new UserMiniDTO(seller.getUser_id(), seller.getUser_name())));
        return new FollowedDTO(user_id, userName, userMiniDTOS);
    }

    /**
     * Punto 3
     * Obtine un listado de todos los usuarios que siguen a un determinado vendedor
     * @ param user_id
     * @return lista de seguidores de un vendedor
     */
    @Override
    public UserFollowersListDTO FollowersList(int user_id) {

        Seller sellerById = sellerRepository.findById(user_id);
        UserFollowersListDTO userFollowersList = new UserFollowersListDTO();

        if(sellerById == null){
            throw  new NotFoundException("El usuario no existe");
        }


        // si hay lista de usuarios
        userFollowersList.setUser_id(sellerById.getUser_id());
        userFollowersList.setUser_name(sellerById.getUser_name());

        // Datos basicos de usuario
        List<UserMiniDTO> userDataList = new ArrayList<>();
        List<User> userFollower = sellerById.getFollowers();

        if(!userFollower.isEmpty()){
            for(User user : userFollower){
                UserMiniDTO userData = new UserMiniDTO();
                userData.setUser_id(user.getUser_id());
                userData.setUser_name(user.getUser_name());

                // agregando a lista de usuarios
                userDataList.add(userData);
            }
        }

        // agregando los datos de los seguidores a los datos de usuario consultado
        userFollowersList.setFollowers(userDataList);

        return userFollowersList;
    }

    /**
     * Endpoint 7
     * Un usuario deja de seguir a otro en base al id de cada uno
     * @ param user_id, userIdToUnfollow
     * @return booleano para indicar si la operación fue exitosa o no
     **/
    @Override
    public UnfollowDTO unfollow(int userId, int userIdToUnfollow) {

        List<User> users = userRepository.getAll();

        Optional<User> userToEdit = users.stream()
                .filter(u -> u.getUser_id() == userId)
                .findFirst();

        // Si se encuentra el userId se modifica
        if (userToEdit.isPresent()){

            // Buscar el seller en la lista de seguidos (followed) del usuario
            Optional<Seller> seller = userToEdit.get().getFollowed().stream()
                    .filter(s -> s.getUser_id() == userIdToUnfollow)
                    .findFirst();

            // Si el vendedor existe en la lista de seguidos del usuario removerlo
            if (seller.isPresent()) {
                userToEdit.get().getFollowed().remove(seller.get());

                // Actualizar repositorio UserRepository
                userRepository.updateUser(userToEdit.get().getUser_id(), userToEdit.get());

                // Buscar en el repositorio SellerRepository y actualizar los seguidores (followers) del vendedor
                seller.get().getFollowers().remove(userToEdit.get());
                sellerRepository.updateUser(seller.get().getUser_id(), seller.get());
                return new UnfollowDTO("El usuario userId: " + userId + " ha dejado de seguir a userId: " + userIdToUnfollow);
            // Si el usuario no sigue al vendedor no se puede dejar de seguir y se lanza la siguiente excepción
            } else {
                throw new NotFoundException("El usuario userId: " + userId + " no sigue al vendedor userId: " + userIdToUnfollow);
            }

        // Si no existe el usuario en la base de datos no se puede realizar la operación
        } else {
            throw new NotFoundException("No se encontró el usuario a editar. userId: " + userId +" Recuerda que los vendedores no pueden seguir usuarios");
        }
    }

    @Override
    public FollowedDTO orderFollowsDto(int userId, String order) {
        FollowedDTO followedsDto = getUserFollowedList(userId);
        List<UserMiniDTO> followed = followedsDto.getFollowed();
        if (order.equals("name_asc")) {
            followedsDto.setFollowed(followed.stream()
                    .sorted(Comparator.comparing(UserMiniDTO::getUser_name)).toList());
        }else if (order.equals("name_desc")){
            followedsDto.setFollowed(followed.stream()
                    .sorted(Comparator.comparing(UserMiniDTO::getUser_name, Comparator.reverseOrder()))
                    .toList());
        }
        return followedsDto;
    }

    @Override
    public UserFollowersListDTO orderFollowersDto(int userId, String order) {
        UserFollowersListDTO followersDto = FollowersList(userId);
        List<UserMiniDTO> followers = followersDto.getFollowers();
        if (order.equals("name_asc")) {
            followersDto.setFollowers(followers.stream()
                    .sorted(Comparator.comparing(UserMiniDTO::getUser_name)).toList());
        }else if (order.equals("name_desc")){
            followersDto.setFollowers(followers.stream()
                    .sorted(Comparator.comparing(UserMiniDTO::getUser_name, Comparator.reverseOrder()))
                    .toList());
        }
        return followersDto;
    }
    @Override
    public UserFollowedPostListDTO userFollowedPostList(int user_id) {
        User user = userRepository.findById(user_id);

        LocalDate limitDateOfPost = LocalDate.now().minusDays(14);

        List<Integer> sellersIds = user.getFollowed().stream().map(User::getUser_id).toList();
        List<PostDto> listOfPosts = postRepository.getAllPosts().stream()
                .filter(post -> sellersIds.contains(post.getUser_id()))
                .filter(post -> limitDateOfPost.isBefore(post.getDate()))
                .map(post -> mapper.convertValue(post, PostDto.class))
                .toList();

        return new UserFollowedPostListDTO(user_id, listOfPosts);
    }
    @Override
    public UserFollowedPostListDTO orderByDateFollowedSellers(int id, String order) {
        UserFollowedPostListDTO lista = userFollowedPostList(id);
        List<PostDto> posts = lista.getPosts();

        if (order.equals("date_asc")) {
            lista.setPosts(posts.stream()
                    .sorted(Comparator.comparing(PostDto::getDate))
                    .toList());
        } else if (order.equals("date_desc")) {
            lista.setPosts(posts.stream()
                    .sorted(Comparator.comparing(PostDto::getDate).reversed())
                    .toList());
        }

        return lista;
    }

}
