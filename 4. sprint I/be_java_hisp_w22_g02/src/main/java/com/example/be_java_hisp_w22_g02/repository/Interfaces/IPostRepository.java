package com.example.be_java_hisp_w22_g02.repository.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;

import java.util.List;

public interface IPostRepository {
    Post save(Post post);
    List<Post> getAllPromotionPosts(int userId);

}
