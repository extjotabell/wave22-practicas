package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.SellerDto;
import com.meli.be_java_hisp_w22_g01.dto.UserDto;
import com.meli.be_java_hisp_w22_g01.dto.response.UserFollowersListDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.UserMiniDTO;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements IUserService{

    @Autowired
    IUserRepository userRepository;

    /**
     * Punto 3
     * Obtine un listado de todos los usuarios que siguen a un determinado vendedor
     * @param user_id
     * @return lista de seguidores de un vendedor
     */
    @Override
    public UserFollowersListDTO FollowersList(int user_id) {

        User usersById = userRepository.findById(user_id);
        UserFollowersListDTO userFollowersList = new UserFollowersListDTO();

        // si hay lista de usuarios
        userFollowersList.setUser_id(usersById.getUser_id());
        userFollowersList.setUser_name(usersById.getUser_name());

        // Datos basicos de usuario
        List<UserMiniDTO> userDataList = new ArrayList<>();
        List<Seller> userFollower = usersById.getFollowed();

        if(!userFollower.isEmpty()){
            for(Seller seller : userFollower){
                UserMiniDTO userData = new UserMiniDTO();
                userData.setUser_id(seller.getUser_id());
                userData.setUser_name(seller.getUser_name());

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
     * @param user_id, userIdToUnfollow
     * @return booleano para indicar si la operación fue exitosa o no
     **/
    @Override
    public boolean unfollow(int userId, int userIdToUnfollow) {

        List<User> users = userRepository.getAll();

        Optional<User> userToEdit = users.stream()
                .filter(u -> u.getUser_id() == userId)
                .findFirst();

        // si se encuentra el userId se modifica
        if (userToEdit.isPresent()){

            // Buscar el seller en la lista de seguidos (followed) del usuario
            Optional<Seller> seller = userToEdit.get().getFollowed().stream()
                    .filter(s -> s.getUser_id() == userIdToUnfollow)
                    .findFirst();

            // si el vendedor existe en la lista de seguidos del usuario removerlo
            if (seller.isPresent()) {
                userToEdit.get().getFollowed().remove(seller.get());

                // Actualizar repositorio
                userRepository.updateUser(userToEdit.get().getUser_id(), userToEdit.get());
                return true;

            }
        }
        return false;
    }
}
