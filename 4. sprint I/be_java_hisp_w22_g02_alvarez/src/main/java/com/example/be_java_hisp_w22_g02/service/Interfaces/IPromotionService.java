package com.example.be_java_hisp_w22_g02.service.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.request.PostPromoDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PromoPostCountDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserDTO;

public interface IPromotionService {
    void addPromoPost(PostPromoDTO productDto);
    PromoPostCountDTO getPromoPostsById(Integer id);
    UserDTO getAllPostsById(Integer id);
}
