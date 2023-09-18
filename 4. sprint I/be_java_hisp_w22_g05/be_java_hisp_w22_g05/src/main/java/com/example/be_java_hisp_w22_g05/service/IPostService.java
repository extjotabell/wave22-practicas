package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.dto.*;

import java.util.List;

public interface IPostService {

    void saveNewPost(PostDto postDto);
    void saveNewPostPromo(PostPromoDto postPromoDto);
    List<PostDto> getListPostsFromSellersFollowed(int userId, String order);

    PostPromoCountDto getNumberPromotions(int userId);

    PostPromotionsDto getPromotions(int userId);
}
