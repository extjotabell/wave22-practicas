package com.example.be_java_hisp_w22_g02.repository.Interfaces;

import com.example.be_java_hisp_w22_g02.entity.Promotion;

import java.util.List;

public interface IPromotionRepository {
    void add(Promotion promotion);
    List<Promotion> findAll();
}
