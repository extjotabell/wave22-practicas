package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.ProductDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.ResponseDTO;
import com.w22_g03.be_java_hisp_w22_g03.exception.BadRequestException;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    PostServiceImpl postService;

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
        PostDTO postDTO = new PostDTO(1L, 2L, LocalDate.of(2023, 9, 20), new ProductDTO(), 1, 1000D);
        postService.addPost(postDTO);
        userService.startFollowing(1, 2);

        //Act
        ResponseDTO response = userService.stopFollowing(1,2);

        //Assert
        Assertions.assertEquals(new ResponseDTO("1 successfully unfollowed 2"), response);
    }

    @Test
    void stopFollowingCantUnfollowThemselvesTestFail(){
        //Act & Assert
        Exception exception = Assertions.assertThrows(BadRequestException.class, ()->{
            userService.stopFollowing(1, 1);
        });
        Assertions.assertEquals("User can't unfollow themselves.", exception.getMessage());
    }

    @Test
    void stopFollowingCantUnfollowIfDidntFollowTestFail(){
        //Act & Assert
        Exception exception = Assertions.assertThrows(BadRequestException.class, ()->{
            userService.stopFollowing(1, 2);
        });
        Assertions.assertEquals("You are not a follower of this user.", exception.getMessage());
    }

    @Test
    void userPopsFollowerTestOk(){
        //Arrange
        PostDTO postDTO = new PostDTO(1L, 2L, LocalDate.of(2023, 9, 20), new ProductDTO(), 1, 1000D);
        postService.addPost(postDTO);
        userService.startFollowing(1, 2);
        User follower = userService.getUserById(1L);
        User userToUnfollow = userService.getUserById(2L);

        //Act
        userToUnfollow.popFollower(follower);

        //Assert
        Assertions.assertTrue(userToUnfollow.getFollowers().isEmpty());
    }

    @Test
    void userPopsFollowedTestOk(){
        //Arrange
        PostDTO postDTO = new PostDTO(1L, 2L, LocalDate.of(2023, 9, 20), new ProductDTO(), 1, 1000D);
        postService.addPost(postDTO);
        userService.startFollowing(1, 2);
        User follower = userService.getUserById(1L);
        User userToUnfollow = userService.getUserById(2L);

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