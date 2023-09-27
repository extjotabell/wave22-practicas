package com.w22_g03.be_java_hisp_w22_g03.repository;

import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import com.w22_g03.be_java_hisp_w22_g03.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

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
    @DisplayName("Find Followed Posts from last 2 weeks")
    void findTwoWeekOldPostsFromFollowedByUser() {

        User seller = TestUtilGenerator.createTestUserSeller(2L, "Seller");
        User user = TestUtilGenerator.createTestUser(1L, "Renzo");
        user.getFollowed().add(seller);

        List<Post> twoWeekOldPostsFromFollowedByUser = postRepository.findTwoWeekOldPostsFromFollowedByUser(user);
        Assertions.assertEquals(1, twoWeekOldPostsFromFollowedByUser.size());
    }

}