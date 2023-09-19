package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.PromoPostDto;
import com.meli.be_java_hisp_w22_g01.dto.response.CountPromoPostDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.CreatePromoPostDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.PromoPostsSellerDTO;
import com.meli.be_java_hisp_w22_g01.entity.PromoPost;

public interface IPostService {
    void createPost (PostDto postDto);

    void createPromoPost (PromoPostDto promoPostDto);

    CountPromoPostDTO countPromoPost(int user_id);

    PromoPostsSellerDTO getPromoPostSeller(int user_id);
}
