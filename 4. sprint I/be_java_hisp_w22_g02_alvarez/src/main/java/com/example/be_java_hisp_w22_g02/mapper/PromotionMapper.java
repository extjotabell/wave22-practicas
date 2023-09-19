package com.example.be_java_hisp_w22_g02.mapper;

import com.example.be_java_hisp_w22_g02.dto.request.PostPromoDTO;
import com.example.be_java_hisp_w22_g02.entity.Promotion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PromotionMapper {
    PostPromoDTO toDto(Promotion promotion);
    Promotion toEntity(PostPromoDTO postPromoDTO);
}
