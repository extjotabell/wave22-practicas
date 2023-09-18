package com.w22_g03.be_java_hisp_w22_g03_bayarri.service;

import com.w22_g03.be_java_hisp_w22_g03_bayarri.dto.NumberOfPromoPostDTO;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.dto.UserFollowedSellersPostsDTO;

public interface PostService {

    PostDTO addPost(PostDTO postDTO);

    UserFollowedSellersPostsDTO  getFollowedUsersPostsById(long userId);

    UserFollowedSellersPostsDTO getFollowedUsersPostsById(long userId, String order);

    NumberOfPromoPostDTO countPromoPostBySeller(long userId);

}
