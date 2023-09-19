package com.example.be_java_hisp_w22_g02.service.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.request.PromotionDto;
import com.example.be_java_hisp_w22_g02.dto.response.TotalPromotionsDto;

public interface IPromotionService {
    void addNewPromo(PromotionDto dto);

    TotalPromotionsDto getTotalPromotionsByUserId(int userId);
}
