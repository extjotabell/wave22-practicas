package com.w22_g03.be_java_hisp_w22_g03_bayarri.repository;

import com.w22_g03.be_java_hisp_w22_g03_bayarri.model.Post;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@AllArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    UserRepository userRepository;

    @Override
    public Post savePost(Post post) {
        post.getUser().getPosts().add(post);
        return post;
    }

    public List<Post> findTwoWeekOldPostsFromFollowedByUser(User user) {
        List<User> followed = user.getFollowed();
        return followed.stream()
                .flatMap(f -> f.getPosts().stream())
                .filter(p -> p.getDate().isAfter(LocalDate.now().minusDays(14)))
                .toList();
    }

    @Override
    public long countPosts() {
        return this.userRepository.findAll().stream().mapToLong(user -> user.getPosts().size()).sum();
    }
}
