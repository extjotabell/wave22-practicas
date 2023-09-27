package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Seller;

public interface ISellerRepository {
    Seller findById(int sellerId);
    void addFollower(int idFollower, int idSeller);
    void updateUser(int sellerId, Seller seller);
}
