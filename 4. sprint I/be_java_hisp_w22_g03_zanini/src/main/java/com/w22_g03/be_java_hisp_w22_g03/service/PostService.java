package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.*;

import java.util.Map;

public interface PostService {

    PostDTO addPost(PostDTO postDTO);

    UserFollowedSellersPostsDTO  getFollowedUsersPostsById(long userId);

    UserFollowedSellersPostsDTO getFollowedUsersPostsById(long userId, String order);

    PromoPostDTO addPromoPost(PromoPostDTO promoPostDTO);

    NumberOfPromoProductsDTO countOfPromoProductByVendor(Long userId);

    PostByVendorDTO listOfPromoProductByVendor(Long userId);

    PostByVendorDTO promoProductsByFilter(Map<String, String> params);
}
