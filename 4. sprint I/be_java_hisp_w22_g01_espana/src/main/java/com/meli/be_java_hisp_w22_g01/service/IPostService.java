package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.PromoPostDto;
import com.meli.be_java_hisp_w22_g01.dto.response.CountPromoPostDTO;

public interface IPostService {
    void createPost (PostDto postDto);

    void createPromoPost (PromoPostDto promoPostDto);

    CountPromoPostDTO countPromoPost(int user_id);


}
