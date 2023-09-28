package com.example.be_java_hisp_w22_g02.service.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.response.TwoWeeksPostDTO;
import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserPromoCountDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;

import java.util.List;

public interface IPostService {
    TwoWeeksPostDTO getLastTwoWeeksPostByUser(int userId, String order);

    PostDTO addNewPost(PostDTO dto);
    PostDTO addPromoPost(PostDTO dto);
    UserPromoCountDTO getTotalPromoCount(int user_id);
    List<PostDTO> getAllPromotionPosts(int user_id);
}
