package com.meli.be_java_hisp_w22_g01.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImp implements IUserRepository{

    private List<User> list_of_users;

    public UserRepositoryImp(){
        this.list_of_users = new ArrayList<>();

        User User1 = new User();
        User1.setUser_id(6);
        User1.setUser_name("Emma");
    }

    @Override
    public void save(User user) {

    }

    @Override
    public List<User> getAll() {
        return this.list_of_users;
    }

    /**
     * Busca un usuario por su id
     * @param user_id
     * @return devuelve el objeto usuario, caso contrario null si no esta
     */
    @Override
    public User findById(int user_id) {

        for(User user: this.list_of_users){
            if(user.getUser_id() == user_id){
                return user;
            }
        }

        throw new NotFoundException("No existe el usuario");
    }
}
