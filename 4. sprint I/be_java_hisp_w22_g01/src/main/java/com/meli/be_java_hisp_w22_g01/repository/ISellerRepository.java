package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;


import java.util.List;

public interface ISellerRepository {
    void save (Seller seller);
    List<Seller> getAll ();
    Seller findById(int seller_id);

    void addFollower(int idFollower, int idSeller);
    void updateUser(int user_id, Seller seller);
    List<User> getAllFollowers(Seller seller);
}
