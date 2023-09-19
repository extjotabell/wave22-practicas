package com.example.be_java_hisp_w22_g02.repository.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.response.PromotionListDTO;
import com.example.be_java_hisp_w22_g02.entity.Promotion;

import java.util.List;

public interface IPromotionRepository {
    String addPromotionPost(Promotion promotion);

    void savePromotion(Promotion promotion);

    List<Promotion> getPromotionsById(int id);

}
