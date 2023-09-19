package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.response.SellerPromoDTO;
import com.meli.be_java_hisp_w22_g01.entity.Post;

import java.util.List;

public interface IPostService {
    void createPost (PostDto postDto);
    List<Post> getAllpost();

    SellerPromoDTO countPromosByUser(int user_id);

}
