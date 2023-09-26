package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.NumberOfFollowersDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.ResponseDTO;
import com.w22_g03.be_java_hisp_w22_g03.exception.BadRequestException;
import com.w22_g03.be_java_hisp_w22_g03.exception.NotFoundException;
import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import com.w22_g03.be_java_hisp_w22_g03.repository.UserRepository;
import com.w22_g03.be_java_hisp_w22_g03.util.TestUtilGenerator;
import com.w22_g03.be_java_hisp_w22_g03.dto.FollowedDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.FollowerDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
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

    //T-0002
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

    // T-0007
    @Test
    void getNumberOfFollowersTestOk() {
        //Arrange
        Post post = new Post();
        User userToFollow = new User(1L, "Juana", List.of(post), new ArrayList<>(), new ArrayList<>());
        User follower1 = new User(2L, "Ana", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User follower2 = new User(3L, "Ana", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User follower3 = new User(4L, "Ana", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        when(userRepo.findById(1L)).thenReturn(userToFollow);
        when(userRepo.findById(2L)).thenReturn(follower1);
        when(userRepo.findById(3L)).thenReturn(follower2);
        when(userRepo.findById(4L)).thenReturn(follower3);
        userService.startFollowing(2, 1);
        userService.startFollowing(3, 1);
        userService.startFollowing(4, 1);

        //Act
        NumberOfFollowersDTO numberDto = userService.getNumberOfFollowers(1);

        //Assert
        Assertions.assertEquals(3, numberDto.getFollowers_count());
    }

    @Test
    void getNumberOfFollowersEmptyTestOk() {
        //Arrange
        Post post = new Post();
        User userToFollow = new User(1L, "Juana", List.of(post), new ArrayList<>(), new ArrayList<>());
        when(userRepo.findById(1L)).thenReturn(userToFollow);

        //Act
        NumberOfFollowersDTO numberDto = userService.getNumberOfFollowers(1);

        //Assert
        Assertions.assertEquals(0, numberDto.getFollowers_count());
    }

    @Test
    void getNumberOfFollowersUserNotFoundFailTest() {
        //Act & Assert
        Assertions.assertThrows(NotFoundException.class, () -> {
            NumberOfFollowersDTO numberDto = userService.getNumberOfFollowers(2);
        });
    }

    //T-0004
    @Test
    void getFollowersOrderByNameAscOk() {
        //Arrange
        User userToGetFollowers = new User(1, "Gaspar", null,null, new ArrayList<>());
        User followerUser = new User(2, "Franco", null, null, null);
        User followerUser2 = new User(3, "Ezequiel", null, null, null);
        User followerUser3 = new User(4, "Matias", null, null, null);
        userToGetFollowers.getFollowers().add(followerUser);
        userToGetFollowers.getFollowers().add(followerUser2);
        userToGetFollowers.getFollowers().add(followerUser3);
        List<User> followers = userToGetFollowers.getFollowers();
        String orderByNameAsc = "name_asc";

        //Act
        when(userRepo.findById(userToGetFollowers.getUserId())).thenReturn(userToGetFollowers);
        when(userRepo.findFollowers((int)userToGetFollowers.getUserId())).thenReturn(followers);
        FollowerDTO followersOfUser1 = userService.getFollowers(((int) userToGetFollowers.getUserId()),orderByNameAsc);

        //Assert
        boolean isAscendingOrder = IntStream.range(0, followersOfUser1.getFollowers().size() - 1) //Compares that all the names of the followers are ordered ascending
                .allMatch(i -> followersOfUser1.getFollowers().get(i).getUsername()
                        .compareTo(followersOfUser1.getFollowers().get(i + 1).getUsername()) <= 0);
        assertTrue(isAscendingOrder);
    }

    //T-0004
    @Test
    void getFollowersOrderByNameDescOk() {
        //Arrange
        User userToGetFollowers = new User(1, "Gaspar", null,null, new ArrayList<>());
        User followerUser = new User(2, "Franco", null, null, null);
        User followerUser2 = new User(3, "Ezequiel", null, null, null);
        User followerUser3 = new User(4, "Matias", null, null, null);
        userToGetFollowers.getFollowers().add(followerUser);
        userToGetFollowers.getFollowers().add(followerUser2);
        userToGetFollowers.getFollowers().add(followerUser3);
        List<User> followers = userToGetFollowers.getFollowers();
        String orderByNameAsc = "name_desc";

        //Act
        when(userRepo.findById(userToGetFollowers.getUserId())).thenReturn(userToGetFollowers);
        when(userRepo.findFollowers((int)userToGetFollowers.getUserId())).thenReturn(followers);
        FollowerDTO followersOfUser1 = userService.getFollowers(((int) userToGetFollowers.getUserId()),orderByNameAsc);

        //Assert
        boolean isDescendingOrder = IntStream.range(0, followersOfUser1.getFollowers().size() - 1) //Compares that all the names of the followers are ordered descending
                .allMatch(i -> followersOfUser1.getFollowers().get(i).getUsername()
                        .compareTo(followersOfUser1.getFollowers().get(i + 1).getUsername()) >= 0);
        assertTrue(isDescendingOrder);
    }

    //T-0004
    @Test
    void getFollowersOrderByParameterNotOk() {
        //Arrange
        User userToGetFollowers = new User(1, "Gaspar", null,null, new ArrayList<>());
        User followerUser = new User(2, "Franco", null, null, null);
        User followerUser2 = new User(3, "Ezequiel", null, null, null);
        userToGetFollowers.getFollowers().add(followerUser);
        userToGetFollowers.getFollowers().add(followerUser2);
        List<User> followers = userToGetFollowers.getFollowers();
        String invalidOrder = "invalid_order";

        //Act and assert
        when(userRepo.findById(userToGetFollowers.getUserId())).thenReturn(userToGetFollowers);
        when(userRepo.findFollowers((int)userToGetFollowers.getUserId())).thenReturn(followers);
        assertThrows(BadRequestException.class, () -> userService.getFollowers(((int) userToGetFollowers.getUserId()),invalidOrder));
    }

    //T-0004
    @Test
    void getFollowedOrderByNameAscOk() {
        //Arrange
        User userToGetFollowed = new User(1, "Gaspar", null,new ArrayList<>(), null);
        User followerUser = new User(2, "Franco", null, null, null);
        User followerUser2 = new User(3, "Ezequiel", null, null, null);
        User followerUser3 = new User(4, "Matias", null, null, null);
        userToGetFollowed.getFollowed().add(followerUser);
        userToGetFollowed.getFollowed().add(followerUser2);
        userToGetFollowed.getFollowed().add(followerUser3);
        List<User> followed = userToGetFollowed.getFollowed();
        String orderByNameAsc = "name_asc";

        //Act
        when(userRepo.findById(userToGetFollowed.getUserId())).thenReturn(userToGetFollowed);
        when(userRepo.findFollowed((int)userToGetFollowed.getUserId())).thenReturn(followed);
        FollowedDTO followedOfUser1 = userService.getFollowed(((int) userToGetFollowed.getUserId()),orderByNameAsc);

        //Assert
        boolean isAscendingOrder = IntStream.range(0, followedOfUser1.getFollowed().size() - 1) //Compares that all the names of the followers are ordered ascending
                .allMatch(i -> followedOfUser1.getFollowed().get(i).getUsername()
                        .compareTo(followedOfUser1.getFollowed().get(i + 1).getUsername()) <= 0);
        assertTrue(isAscendingOrder);
    }

    //T-0004
    @Test
    void getFollowedOrderByNameDescOk() {
        //Arrange
        User userToGetFollowed = new User(1, "Gaspar", null,new ArrayList<>(), null);
        User followerUser = new User(2, "Franco", null, null, null);
        User followerUser2 = new User(3, "Ezequiel", null, null, null);
        User followerUser3 = new User(4, "Matias", null, null, null);
        userToGetFollowed.getFollowed().add(followerUser);
        userToGetFollowed.getFollowed().add(followerUser2);
        userToGetFollowed.getFollowed().add(followerUser3);
        List<User> followed = userToGetFollowed.getFollowed();
        String orderByNameAsc = "name_desc";

        //Act
        when(userRepo.findById(userToGetFollowed.getUserId())).thenReturn(userToGetFollowed);
        when(userRepo.findFollowed((int)userToGetFollowed.getUserId())).thenReturn(followed);
        FollowedDTO followedOfUser1 = userService.getFollowed(((int) userToGetFollowed.getUserId()),orderByNameAsc);

        //Assert
        boolean isAscendingOrder = IntStream.range(0, followedOfUser1.getFollowed().size() - 1) //Compares that all the names of the followers are ordered ascending
                .allMatch(i -> followedOfUser1.getFollowed().get(i).getUsername()
                        .compareTo(followedOfUser1.getFollowed().get(i + 1).getUsername()) >= 0);
        assertTrue(isAscendingOrder);
    }

    //T-0004
    @Test
    void getFollowedOrderByParameterNotOk() {
        //Arrange
        User userToGetFollowed = new User(1, "Gaspar", null,new ArrayList<>(), null);
        User followerUser = new User(2, "Franco", null, null, null);
        User followerUser2 = new User(3, "Ezequiel", null, null, null);
        userToGetFollowed.getFollowed().add(followerUser);
        userToGetFollowed.getFollowed().add(followerUser2);
        List<User> followed = userToGetFollowed.getFollowed();
        String invalidOrder = "invalid_order";

        //Act and assert
        when(userRepo.findById(userToGetFollowed.getUserId())).thenReturn(userToGetFollowed);
        when(userRepo.findFollowed((int)userToGetFollowed.getUserId())).thenReturn(followed);
        assertThrows(BadRequestException.class, () -> userService.getFollowed(((int) userToGetFollowed.getUserId()),invalidOrder));
    }

    @Test
    void getUserById() {
    }
}