package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Seller;


import java.util.List;

public interface ISellerRepository {
    void save (Seller seller);
    List<Seller> getAll ();
    Seller findById(int seller_id);
}
