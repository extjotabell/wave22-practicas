package com.example.be_java_hisp_w22_g02.repository.Interfaces;

import com.example.be_java_hisp_w22_g02.entity.Promotion;

public interface IPromotionRepository {
    Promotion getById(int id);
    boolean existsById(int id);
    void addNewPromotion(Promotion newPromotion);
}
