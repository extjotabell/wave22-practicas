package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.PromoPostAmountDto;

import java.util.List;

public interface IPostService {

    void saveNewPost(PostDto postDto, boolean hasPromo);

    List<PostDto> getListPostsFromSellersFollowed(int userId, String order);
    PromoPostAmountDto getAmountOfPromos(int userId);
}
