package com.example.be_java_hisp_w22_g02.repository.Implementations;

import com.example.be_java_hisp_w22_g02.entity.Promotion;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IPromotionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class PromotionRepositoryImpl implements IPromotionRepository {

    List<Promotion> dbPromotion = new ArrayList<>();
    @Override
    public String addPromotionPost(Promotion promotion) {
        savePromotion(promotion);
        return "Promotion saved successfully";
    }

    @Override
    public void savePromotion(Promotion promotion) {
     dbPromotion.add(promotion);
    }

    @Override
    public List<Promotion> getPromotionsById(int id) {
       return dbPromotion.stream().filter(p->p.getUserId() == id).collect(Collectors.toList());
    }


}
