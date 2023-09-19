package com.example.be_java_hisp_w22_g02.mapper;

import com.example.be_java_hisp_w22_g02.dto.request.PromotionPostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PromotionDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserFollowedDTO;
import com.example.be_java_hisp_w22_g02.entity.Promotion;
import com.example.be_java_hisp_w22_g02.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PromotionMapper {
    PromotionPostDTO toDto (Promotion promo);
    Promotion toEntity(PromotionPostDTO promoDTO);
}
