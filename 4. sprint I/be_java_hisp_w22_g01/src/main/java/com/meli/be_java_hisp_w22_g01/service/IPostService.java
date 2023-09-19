package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.response.CountFollowedDto;
import com.meli.be_java_hisp_w22_g01.dto.response.PromoPostListDto;


public interface IPostService {
    void createPost (PostDto postDto);
    CountFollowedDto countPromo(int userId);
    PromoPostListDto listPromo(int userId);
}
