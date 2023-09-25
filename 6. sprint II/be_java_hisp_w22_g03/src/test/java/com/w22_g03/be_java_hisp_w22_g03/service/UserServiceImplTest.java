package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.ProductDTO;
import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import com.w22_g03.be_java_hisp_w22_g03.dto.ResponseDTO;
import org.springframework.boot.test.context.SpringBootTest;
import com.w22_g03.be_java_hisp_w22_g03.exception.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    @Mock
    UserRepository userRepo;

    @InjectMocks
    UserServiceImpl userService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void startFollowing() {
    }

    //T-0007
    @Test
    void stopFollowingTestOk() {
        //Arrange
        Post post = new Post();
        User newFollower = new User(1L, "Ana", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userToFollow = new User(2L, "Juana", List.of(post), new ArrayList<>(), new ArrayList<>());
        when(userRepo.findById(1L)).thenReturn(newFollower);
        when(userRepo.findById(2L)).thenReturn(userToFollow);
        userService.startFollowing(1, 2);

        //Act
        ResponseDTO response = userService.stopFollowing(1, 2);

        //Assert
        Assertions.assertEquals(new ResponseDTO("1 successfully unfollowed 2"), response);
    }

    @Test
    void stopFollowingCantUnfollowThemselvesTestFail() {
        //Act & Assert
        Exception exception = Assertions.assertThrows(BadRequestException.class, () -> {
            userService.stopFollowing(1, 1);
        });
        Assertions.assertEquals("User can't unfollow themselves.", exception.getMessage());
    }

    @Test
    void stopFollowingCantUnfollowIfDidntFollowTestFail() {
        //Arrange
        Post post = new Post();
        User newFollower = new User(1L, "Ana", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userToFollow = new User(2L, "Juana", List.of(post), new ArrayList<>(), new ArrayList<>());
        when(userRepo.findById(1L)).thenReturn(newFollower);
        when(userRepo.findById(2L)).thenReturn(userToFollow);

        //Act & Assert
        Exception exception = Assertions.assertThrows(BadRequestException.class, () -> {
            userService.stopFollowing(1, 2);
        });
        Assertions.assertEquals("You are not a follower of this user.", exception.getMessage());
    }

    @Test
    void userPopsFollowerTestOk() {
        //Arrange
        Post post = new Post();
        User follower = new User(1L, "Ana", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userToUnfollow = new User(2L, "Juana", List.of(post), new ArrayList<>(), new ArrayList<>());
        when(userRepo.findById(1L)).thenReturn(follower);
        when(userRepo.findById(2L)).thenReturn(userToUnfollow);
        userService.startFollowing(1, 2);

        //Act
        userToUnfollow.popFollower(follower);

        //Assert
        Assertions.assertTrue(userToUnfollow.getFollowers().isEmpty());
    }

    @Test
    void userPopsFollowedTestOk() {
        //Arrange
        Post post = new Post();
        User follower = new User(1L, "Ana", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User userToUnfollow = new User(2L, "Juana", List.of(post), new ArrayList<>(), new ArrayList<>());
        when(userRepo.findById(1L)).thenReturn(follower);
        when(userRepo.findById(2L)).thenReturn(userToUnfollow);
        userService.startFollowing(1, 2);

        //Act
        follower.popFollowed(userToUnfollow);

        //Assert
        Assertions.assertTrue(follower.getFollowed().isEmpty());
    }

    @Test
    void getNumberOfFollowers() {
    }

    @Test
    void getFollowers() {
    }

    @Test
    void getFollowed() {
    }

    @Test
    void getUserById() {
    }
}