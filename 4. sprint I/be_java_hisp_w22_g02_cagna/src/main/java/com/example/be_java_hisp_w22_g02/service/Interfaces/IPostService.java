package com.example.be_java_hisp_w22_g02.service.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.response.FollowedPostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PromoProductCountDTO;
import com.example.be_java_hisp_w22_g02.dto.response.TwoWeeksPostDTO;
import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;

import java.util.List;

public interface IPostService {
    TwoWeeksPostDTO getLastTwoWeeksPostByUser(int userId, String order);

    PostDTO addNewPost(PostDTO dto);
    PostDTO addNewPromo(PostDTO dto);
    PromoProductCountDTO getPromoCountByUserId(int userId);
    List<PostDTO> getPromoPostsByUserId(int userId);


}
