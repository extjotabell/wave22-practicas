package com.example.be_java_hisp_w22_g02.service.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.response.CountPostPromoByUserDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PostPromoByUserDTO;
import com.example.be_java_hisp_w22_g02.dto.response.TwoWeeksPostDTO;
import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;

public interface IPostService {
    TwoWeeksPostDTO getLastTwoWeeksPostByUser(int userId, String order);

    PostDTO addNewPost(PostDTO dto);

    CountPostPromoByUserDTO countPostPromoByUser(int userId);

    PostPromoByUserDTO getPostPromoByUser(int userId);

}
