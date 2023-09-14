package com.meli.be_java_hisp_w22_g01.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImp {

    private List<User> list_of_users = new ArrayList<>();

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
    @Override
    public void updateUser(int user_id, User user) {
        User oldUser = this.findById(user_id);
        int indexPos = this.list_of_users.indexOf(oldUser);
        this.list_of_users.set(indexPos, user);
    }
}
