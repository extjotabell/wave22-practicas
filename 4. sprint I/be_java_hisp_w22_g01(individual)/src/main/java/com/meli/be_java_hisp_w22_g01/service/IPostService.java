package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.PostDiscountDto;
import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.response.CountDiscountPostDto;

import java.util.List;

public interface IPostService {
    void createPost (PostDto postDto);

    void createPostWithDiscount(PostDiscountDto postDiscountDto);

    CountDiscountPostDto countDiscount(int userId);

}
