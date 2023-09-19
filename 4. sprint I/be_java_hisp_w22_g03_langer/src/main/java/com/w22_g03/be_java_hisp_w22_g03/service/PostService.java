package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.NumberOfPromosDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.PostsBySellerDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.UserFollowedSellersPostsDTO;
import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PostService {

    PostDTO addPost(PostDTO postDTO);

    UserFollowedSellersPostsDTO  getFollowedUsersPostsById(long userId);

    UserFollowedSellersPostsDTO getFollowedUsersPostsById(long userId, String order);

    PostDTO addPromoPost(PostDTO postDTO);

    NumberOfPromosDTO getPromoCount(int userId);

    PostsBySellerDTO getPromoList(int userId, String since, String upTo);
}
