package com.w22_g03.be_java_hisp_w22_g03_bayarri.repository;

import com.w22_g03.be_java_hisp_w22_g03_bayarri.model.Post;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.model.User;

import java.util.List;

public interface PostRepository {

    Post savePost(Post post);

    List<Post> findTwoWeekOldPostsFromFollowedByUser(User user);

    long countPosts();

    List<Post> findPromoPostByUser(User user);
}

