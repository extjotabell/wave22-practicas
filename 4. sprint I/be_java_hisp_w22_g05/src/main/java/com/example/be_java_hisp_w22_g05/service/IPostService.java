package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.PostPromoCountDto;
import com.example.be_java_hisp_w22_g05.dto.UserPostPromoDto;

import java.util.List;

public interface IPostService {

    void saveNewPost(PostDto postDto);
    List<PostDto> getListPostsFromSellersFollowed(int userId, String order);

    PostPromoCountDto findQuantityProductsPromoBySeller(int userId);

    UserPostPromoDto findListProductPromoSeller(int userId);
    List<PostDto> findPostAll();

}