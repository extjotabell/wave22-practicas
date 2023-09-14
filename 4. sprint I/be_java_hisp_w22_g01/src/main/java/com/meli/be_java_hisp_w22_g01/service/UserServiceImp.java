package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.SellerDto;
import com.meli.be_java_hisp_w22_g01.dto.UserDto;
import com.meli.be_java_hisp_w22_g01.dto.response.UserFollowersListDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.UserMiniDTO;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.repository.IUserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImp implements IUserService{

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

        // Si no hay usuario con es id, devuelve el dto solo
        if(usersById == null){
            return userFollowersList;
        }

        // si hay lista de usuarios
        userFollowersList.setUser_id(usersById.getUser_id());
        userFollowersList.setUser_name(usersById.getUser_name());

        // Datos basicos de usuario
        List<UserMiniDTO> userDataList = new ArrayList<>();
        List<Seller> userFollower = usersById.getFollowed();

        for(Seller seller : userFollower){
            UserMiniDTO userData = new UserMiniDTO();
            userData.setUser_id(seller.getUser_id());
            userData.setUser_name(seller.getUser_name());

            // agregando a lista de usuarios
            userDataList.add(userData);
        }

        // agregando los datos de los seguidores a los datos de usuario consultado
        userFollowersList.setFollowers(userDataList);

        return userFollowersList;
    }
}
