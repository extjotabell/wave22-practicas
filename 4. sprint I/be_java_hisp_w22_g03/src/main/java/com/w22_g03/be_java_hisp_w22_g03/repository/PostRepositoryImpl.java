package com.w22_g03.be_java_hisp_w22_g03.repository;

import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    UserRepository userRepository;

    @Override
    public Post savePost(Post post) {
        this.userRepository.savePost(post);
        return post;
    }

    public List<Post> findTwoWeekOldPostsFromFollowedByUser(User user) {
        List<User> followed = user.getFollowed();
        return followed.stream()
                .flatMap(f -> f.getPosts().stream())
                .filter(p -> p.getDate().isAfter(LocalDate.now().minusDays(14)))
                .toList();
    }
}
