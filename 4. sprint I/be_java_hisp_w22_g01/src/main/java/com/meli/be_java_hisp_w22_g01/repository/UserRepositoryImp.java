package com.meli.be_java_hisp_w22_g01.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImp implements IUserRepository{

    private List<User> list_of_users = new ArrayList<>();

    public UserRepositoryImp() {

        ISellerRepository sellerRepository = new SellerRepositoryImp();

        //Generar lista de vendedores a seguir
        List<Seller> sellers1 = new ArrayList<>();
        sellers1.add(sellerRepository.findById(1));
        sellers1.add(sellerRepository.findById(3));

        List<Seller> sellers2 = new ArrayList<>();
        sellers2.add(sellerRepository.findById(3));

        List<Seller> sellers3 = new ArrayList<>();
        sellers3.add(sellerRepository.findById(1));
        sellers3.add(sellerRepository.findById(2));
        sellers3.add(sellerRepository.findById(3));

        // Usuarios falsos
        User user1 = new User(4, "Lisa", sellers1);
        User user2 = new User(5, "Bart", sellers2);
        User user3 = new User(6, "Maggie", sellers3);

        this.list_of_users.add(user1);
        this.list_of_users.add(user2);
        this.list_of_users.add(user3);

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
    @Override
    public void updateUser(int user_id, User user) {
        User oldUser = this.findById(user_id);
        int indexPos = this.list_of_users.indexOf(oldUser);
        this.list_of_users.set(indexPos, user);
    }
}
