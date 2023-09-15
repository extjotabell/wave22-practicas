package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.ProductDto;
import com.meli.be_java_hisp_w22_g01.dto.response.*;
import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
import com.meli.be_java_hisp_w22_g01.repository.ISellerRepository;
import com.meli.be_java_hisp_w22_g01.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements IUserService{

    @Autowired
    IUserRepository userRepository;
    @Autowired
    ISellerRepository sellerRepository;
    @Autowired
    ObjectMapper mapper;

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
    public List<FollowedDTO> orderFollowedsDto(int userId, String order) {
        User user = userRepository.findById(userId);
        List<Seller> followeds = userRepository.getAllFolloweds(user);
        if (order.equals("name_asc")) {
            followeds = followeds.stream()
                    .sorted(Comparator.comparing(User::getUser_name)).toList();
        }else if (order.equals("name_desc")){
            followeds = followeds.stream()
                    .sorted(Comparator.comparing(User::getUser_name, Comparator.reverseOrder()))
                    .toList();
        }
        return followeds.stream().map(f -> mapper.convertValue(f, FollowedDTO.class)).toList();
    }

    @Override
    public UserFollowedPostListDTO userFollowedPostList(int user_id) {

        User user = userRepository.findById(user_id);
        UserFollowedPostListDTO userFollowedPostListDTO = new UserFollowedPostListDTO();

        List<Seller> sellerOfUser = user.getFollowed();
        List<PostDto> listOfPost = new ArrayList<>();

        // recorriendo lista de vendedores seguidos por el usuario
        for(Seller seller: sellerOfUser){
            // lista de post publicados por el vendedor
            for(Post post: seller.getPosts()){

                PostDto new_post = new PostDto();
                new_post.setUser_id(post.getUser_id());
                new_post.setPost_id(post.getPost_id());
                new_post.setDate(post.getDate());
                new_post.setProduct(mapper.convertValue(post.getProduct(), ProductDto.class));
                new_post.setCategory(post.getCategory());
                new_post.setPrice(post.getPrice());

                listOfPost.add(new_post);

            }
        }

        userFollowedPostListDTO.setUser_id(user_id);
        userFollowedPostListDTO.setPosts(listOfPost);

        return userFollowedPostListDTO;
    }
}
