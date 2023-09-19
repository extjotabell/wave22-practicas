package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Promo;

import java.util.List;

public interface IPromoRepository {

    List<Promo> getAllPromos();
    void save(Promo promo);
    Promo getById(int id);
}
