package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImp implements IUserRepository{

    private final List<User> userList = new ArrayList<>();

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

        this.userList.add(user1);
        this.userList.add(user2);
        this.userList.add(user3);

    }

    @Override
    public List<User> getAll() {
        return this.userList;
    }

    /**
     * Busca un usuario por su id
     * @param userId
     * @return devuelve el objeto usuario, caso contrario null si no esta
     */
    @Override
    public User findById(int userId) {

        for(User user: this.userList){
            if(user.getUser_id() == userId){
                return user;
            }
        }

        throw new NotFoundException("No existe el usuario");
    }
    @Override
    public void updateUser(int userId, User user) {
        User oldUser = this.findById(userId);
        int indexPos = this.userList.indexOf(oldUser);
        this.userList.set(indexPos, user);
    }

    @Override
    public List<Seller> getAllFollows(User user) {
        return user.getFollowed();
    }
}
