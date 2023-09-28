package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.PostDTO;
import com.meli.be_java_hisp_w22_g01.dto.ProductDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.*;
import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
import com.meli.be_java_hisp_w22_g01.repository.ISellerRepository;
import com.meli.be_java_hisp_w22_g01.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements IUserService{

    private final IUserRepository userRepository;
    private final ISellerRepository sellerRepository;

    @Override
    public FollowedDTO getUserFollowedList(int userId) {
        User usersById = userRepository.findById(userId);
        String userName = usersById.getUser_name();
        List<Seller> followed = usersById.getFollowed();
        List<UserMiniDTO> userMiniDTOS = new ArrayList<>();
        followed.forEach(seller -> userMiniDTOS.add(new UserMiniDTO(seller.getUser_id(), seller.getUser_name())));
        return new FollowedDTO(userId, userName, userMiniDTOS);
    }

    /**
     * Punto 3
     * Obtine un listado de todos los usuarios que siguen a un determinado vendedor
     * @ param userId
     * @return lista de seguidores de un vendedor
     */
    @Override
    public UserFollowersListDTO followersList(int userId) {

        Seller sellerById = sellerRepository.findById(userId);
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
    public MessageDTO unfollow(int userId, int userIdToUnfollow) {

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
                return new MessageDTO("El usuario userId: " + userId + " ha dejado de seguir a userId: " + userIdToUnfollow);
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
    public FollowedDTO orderFollowedDto(int userId, String order) {
        FollowedDTO followedsDto = getUserFollowedList(userId);
        List<UserMiniDTO> followed = followedsDto.getFollowed();
        if (order.equals("name_asc")) {
            followedsDto.setFollowed(followed.stream()
                    .sorted(Comparator.comparing(UserMiniDTO::getUser_name)).toList());
        }else if (order.equals("name_desc")){
            followedsDto.setFollowed(followed.stream()
                    .sorted(Comparator.comparing(UserMiniDTO::getUser_name, Comparator.reverseOrder()))
                    .toList());
        } else {
            throw new BadRequestException("No existe ese método de ordenamiento");
        }
        return followedsDto;
    }

    @Override
    public UserFollowersListDTO orderFollowersDto(int userId, String order) {
        UserFollowersListDTO followersDto = followersList(userId);
        List<UserMiniDTO> followers = followersDto.getFollowers();
        if (order.equals("name_asc")) {
            followersDto.setFollowers(followers.stream()
                    .sorted(Comparator.comparing(UserMiniDTO::getUser_name)).toList());
        }else if (order.equals("name_desc")){
            followersDto.setFollowers(followers.stream()
                    .sorted(Comparator.comparing(UserMiniDTO::getUser_name, Comparator.reverseOrder()))
                    .toList());
        } else {
            throw new BadRequestException("No existe ese método de ordenamiento");
        }
        return followersDto;
    }

    @Override
    public UserFollowedPostListDTO userFollowedPostList(int userId) {
        ObjectMapper mapper = new ObjectMapper();

        User user = userRepository.findById(userId);
        UserFollowedPostListDTO userFollowedPostListDTO = new UserFollowedPostListDTO();

        List<Seller> sellerOfUser = user.getFollowed();
        List<PostDTO> listOfPost = new ArrayList<>();

        LocalDate limitDateOfPost = LocalDate.now().minusDays(14);


        // recorriendo lista de vendedores seguidos por el usuario
        for(Seller seller: sellerOfUser){
            // lista de post publicados por el vendedor
            for(Post post: seller.getPosts()){

                // si la fecha del post esta dentro de las 2 semanas
                if(limitDateOfPost.isBefore(post.getDate())){
                    PostDTO newPost = new PostDTO();
                    newPost.setUser_id(post.getUser_id());
                    newPost.setPost_id(post.getPost_id());
                    newPost.setDate(post.getDate());
                    newPost.setProduct(mapper.convertValue(post.getProduct(), ProductDTO.class));
                    newPost.setCategory(post.getCategory());
                    newPost.setPrice(post.getPrice());

                    listOfPost.add(newPost);
                }
            }
        }

        userFollowedPostListDTO.setUser_id(userId);
        userFollowedPostListDTO.setPosts(listOfPost);

        return userFollowedPostListDTO;
    }
    // US-009
    @Override
    public UserFollowedPostListDTO orderByDateFollowedSellers(int id, String order) {
        UserFollowedPostListDTO lista = userFollowedPostList(id);
        List<PostDTO> posts = lista.getPosts();

        if (order.equals("date_asc")) {
            lista.setPosts(posts.stream()
                    .sorted(Comparator.comparing(PostDTO::getDate))
                    .toList());
        } else if (order.equals("date_desc")) {
            lista.setPosts(posts.stream()
                    .sorted(Comparator.comparing(PostDTO::getDate).reversed())
                    .toList());
        } else {
            throw new BadRequestException("No existe ese método de ordenamiento");
        }

        return lista;
    }

}
