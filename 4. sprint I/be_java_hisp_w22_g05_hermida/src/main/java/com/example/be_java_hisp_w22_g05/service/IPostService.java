package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.PromoPostDto;
import com.example.be_java_hisp_w22_g05.dto.PromoPostListDto;

import java.util.List;

public interface IPostService {

    void saveNewPost(PostDto postDto, boolean isPromo);

    void saveNewPromoPost(PostDto postDto);

    List<PostDto> getListPostsFromSellersFollowed(int userId, String order);

    PromoPostDto getPromoPostsCountFromSeller(int id);

    PromoPostListDto getPromoPostsFromSeller(int id);

}
