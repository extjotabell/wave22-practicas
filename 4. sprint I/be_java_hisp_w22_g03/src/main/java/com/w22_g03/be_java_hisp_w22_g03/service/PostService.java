package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PostService {

    PostDTO addPost(@RequestBody PostDTO postDTO);

    List<PostDTO> getFollowedUsersPostsById(long userId);

    List<PostDTO> getFollowedUsersPostsById(long userId, String order);
}
