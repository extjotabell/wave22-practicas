package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;


import java.util.List;

public interface ISellerRepository {
    void save (Seller seller);
    List<Seller> getAll ();
    Seller findById(int seller_id);

    Seller sumAFollower(int idFollower, int idSeller);

    List<User> getAllFollowers(Seller seller);
}
