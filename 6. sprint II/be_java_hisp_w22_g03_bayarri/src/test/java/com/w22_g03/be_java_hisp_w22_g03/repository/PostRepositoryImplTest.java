package com.w22_g03.be_java_hisp_w22_g03.repository;

import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.model.Product;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PostRepositoryImplTest {

    @InjectMocks
    private PostRepositoryImpl postRepository;

    /**
     * This test method verifies the functionality of the `findTwoWeekOldPostsFromFollowedByUser` method in the `PostRepository` class.
     * It tests whether the method correctly retrieves posts that are two weeks old from users followed by a given user.
     */
    @Test
    void findTwoWeekOldPostsFromFollowedByUser() {

        User seller = new User();
        seller.setUserId(2L);
        seller.setUsername("Seller");
        seller.setPosts(List.of(
                new Post(1L, seller, LocalDate.now(), new Product(), 30, 1000.0, false, 0.0),
                new Post(1L, seller, LocalDate.now().minusDays(14), new Product(), 30, 1000.0, false, 0.0)
        ));

        User user = new User();
        user.setUserId(1L);
        user.setUsername("Renzo");
        user.setFollowed(List.of(seller));
        user.setPosts(List.of());

        List<Post> twoWeekOldPostsFromFollowedByUser = postRepository.findTwoWeekOldPostsFromFollowedByUser(user);
        Assertions.assertEquals(1, twoWeekOldPostsFromFollowedByUser.size());
    }

}