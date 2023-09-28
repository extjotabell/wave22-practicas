package com.w22_g03.be_java_hisp_w22_g03.model;

import com.w22_g03.be_java_hisp_w22_g03.util.TestUtilGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    /*
    * Verifies when user is a seller.
    */
    @Test
    public void testIsSeller() {
        // arrange
        User userWithPosts = TestUtilGenerator.createTestUserSeller(1, "Insua");
        User userWithoutPosts = TestUtilGenerator.createTestUser(2, "Batalla");

        // assert
        assertTrue(userWithPosts.isSeller());
        assertFalse(userWithoutPosts.isSeller());
    }

    /*
    * Verify adding a follower to user"
    */
    @Test
    public void testAddFollower() {
        // arrange
        User user = TestUtilGenerator.createTestUser(1, "Insua");
        User follower = TestUtilGenerator.createTestUser(2, "Batalla");

        // act
        user.addFollower(follower);

        // assert
        assertTrue(user.getFollowers().contains(follower));
    }

    /*
    * Verify adding a followed to user
    */
    @Test
    public void testAddFollowed() {
        // arrange
        User user = TestUtilGenerator.createTestUser(1, "Insua");
        User followedUser = TestUtilGenerator.createTestUser(2, "Batalla");

        // act
        user.addFollowed(followedUser);

        // assert
        assertTrue(user.getFollowed().contains(followedUser));
    }
}
