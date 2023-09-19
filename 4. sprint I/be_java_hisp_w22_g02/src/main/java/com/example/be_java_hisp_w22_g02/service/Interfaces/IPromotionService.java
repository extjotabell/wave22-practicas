package com.example.be_java_hisp_w22_g02.service.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.request.PromotionPostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PromotionCountDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PromotionDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PromotionListDTO;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface IPromotionService {
    PromotionDTO addPromotionPost(PromotionPostDTO promotionPostDTO);

    PromotionCountDTO getPromotionsById(int id);

    PromotionListDTO getListPromotionsById(int userId);
}
