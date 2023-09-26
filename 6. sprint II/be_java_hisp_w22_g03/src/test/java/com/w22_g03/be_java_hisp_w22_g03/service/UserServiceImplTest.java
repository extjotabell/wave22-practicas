package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.ProductDTO;
import com.w22_g03.be_java_hisp_w22_g03.exception.NotFoundException;
import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.repository.UserRepository;
import com.w22_g03.be_java_hisp_w22_g03.util.TestUtilGenerator;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

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
    void startFollowingOk() {
        // arrange
        User follower = TestUtilGenerator.createTestUser(2, "Batalla");
        User followed = TestUtilGenerator.createTestUserSeller(1, "Insua");
        when(userRepo.findById(1)).thenReturn(follower);
        when(userRepo.findById(2)).thenReturn(followed);

        // act
        ResponseDTO response = userService.startFollowing(1, 2);

        //assert
        verify(userRepo, atLeast(2)).findById(anyLong());
        assertEquals("1 successfully followed 2", response.getMessage());
    }

        @Test
    void startFollowing_SameUser() {
        //act & assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> userService.startFollowing(1, 1));
        assertEquals("User can't add themselves.", exception.getMessage());
    }
    @Test
    void startFollowing_UserNotFound() {
        //arrange
        when(userRepo.findById(1)).thenReturn(null);

        //act & assert
        NotFoundException exception = assertThrows(NotFoundException.class, () -> userService.startFollowing(1, 2));
        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void startFollowing_UserNotSeller() {
        // arrange
        User follower = TestUtilGenerator.createTestUser(2, "Batalla");
        User followed = TestUtilGenerator.createTestUser(1, "Insua");
        when(userRepo.findById(1)).thenReturn(follower);
        when(userRepo.findById(2)).thenReturn(followed);

        // act & assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> userService.startFollowing(1, 2));
        assertEquals("User is not seller.", exception.getMessage());
    }

    @Test
    void startFollowing_AlreadyFollowed() {
        // arrange
        User follower = TestUtilGenerator.createTestUser(2, "Batalla");
        User followed = TestUtilGenerator.createTestUserSeller(1, "Insua");
        follower.addFollowed(followed);
        when(userRepo.findById(1)).thenReturn(follower);
        when(userRepo.findById(2)).thenReturn(followed);

        // act & assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> userService.startFollowing(1, 2));
        assertEquals("User cant follow the same seller more than once.", exception.getMessage());
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
        assertEquals(new ResponseDTO("1 successfully unfollowed 2"), response);
    }

    @Test
    void stopFollowingCantUnfollowThemselvesTestFail() {
        //Act & Assert
        Exception exception = assertThrows(BadRequestException.class, () -> {
            userService.stopFollowing(1, 1);
        });
        assertEquals("User can't unfollow themselves.", exception.getMessage());
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
        Exception exception = assertThrows(BadRequestException.class, () -> {
            userService.stopFollowing(1, 2);
        });
        assertEquals("You are not a follower of this user.", exception.getMessage());
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