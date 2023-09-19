package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Promo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PromoRepositoryImp implements IPromoRepository{

    private List<Promo> promoList = new ArrayList<>();
    @Override
    public List<Promo> getAllPromos() {
        return promoList;
    }

    @Override
    public void save(Promo promo) {
        promoList.add(promo);
    }

    @Override
    public Promo getById(int id) {
        return promoList.stream().filter(promo -> promo.getPost_id() == id).findFirst().orElse(null);
    }
}
