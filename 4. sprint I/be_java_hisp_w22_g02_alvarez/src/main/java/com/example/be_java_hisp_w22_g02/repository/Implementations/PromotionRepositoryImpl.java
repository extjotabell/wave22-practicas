package com.example.be_java_hisp_w22_g02.repository.Implementations;

import com.example.be_java_hisp_w22_g02.entity.Promotion;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IPromotionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PromotionRepositoryImpl implements IPromotionRepository {
    private final List<Promotion> products;

    public PromotionRepositoryImpl() {
        products = new ArrayList<>();
    }

    @Override
    public void add(Promotion promotion) {
        products.add(promotion);
    }

    @Override
    public List<Promotion> findAll() {
        return products;
    }
}
