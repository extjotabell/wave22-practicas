package com.example.be_java_hisp_w22_g02.repository.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.response.FollowedPostDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public interface IPostRepository {
    Post save(Post post);

    List<Post> getPostById(int userId);
}
