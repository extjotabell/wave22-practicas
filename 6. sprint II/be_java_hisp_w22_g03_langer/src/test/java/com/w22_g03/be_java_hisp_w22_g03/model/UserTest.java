package com.w22_g03.be_java_hisp_w22_g03.model;

import com.w22_g03.be_java_hisp_w22_g03.repository.UserRepository;
import com.w22_g03.be_java_hisp_w22_g03.service.UserServiceImpl;
import com.w22_g03.be_java_hisp_w22_g03.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserTest {
    @Mock
    UserRepository userRepo;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    public void testIsSeller() {
        // arrange
        User userWithPosts = TestUtilGenerator.createTestUserSeller(1, "Insua");
        User userWithoutPosts = TestUtilGenerator.createTestUser(2, "Batalla");

        // assert
        assertTrue(userWithPosts.isSeller());
        assertFalse(userWithoutPosts.isSeller());
    }

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


    /**
     * This test verifies that the followed user pops followers correctly.
     */
    @Test
    void userPopsFollowerTestOk() {
        //Arrange
        Post post = new Post();
        User follower = new User(1L, "Ana", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followed = new User(2L, "Juana", List.of(post), new ArrayList<>(), new ArrayList<>());
        when(userRepo.findById(1L)).thenReturn(follower);
        when(userRepo.findById(2L)).thenReturn(followed);
        userService.startFollowing(1, 2);

        //Act
        followed.popFollower(follower);

        //Assert
        assertTrue(followed.getFollowers().isEmpty());
    }

    /**
     * This test verifies that the follower user pops followeds correctly.
     */
    @Test
    void userPopsFollowedTestOk() {
        //Arrange
        Post post = new Post();
        User follower = new User(1L, "Ana", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User followed = new User(2L, "Juana", List.of(post), new ArrayList<>(), new ArrayList<>());
        when(userRepo.findById(1L)).thenReturn(follower);
        when(userRepo.findById(2L)).thenReturn(followed);
        userService.startFollowing(1, 2);

        //Act
        follower.popFollowed(followed);

        //Assert
        Assertions.assertTrue(follower.getFollowed().isEmpty());
    }
}
