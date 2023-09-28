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
import org.mockito.Mockito;
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
    User follower;
    User followed;
    User follower2;
    User follower3;

    @Mock
    UserRepository userRepo;

    @InjectMocks
    UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        Post post = new Post();
        follower = new User(1L, "Ana", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        followed = new User(2L, "Juana", List.of(post), new ArrayList<>(), new ArrayList<>());
        follower2 = new User(3L, "Juanita", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        follower3 = new User(4L, "Josefa", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    @AfterEach
    void tearDown() {
    }

     //T-0001

    /*
    * Verifies that startFollowing() successfully initiates a follow action.
    * It checks that the user with ID 1 successfully followed the user with ID 2.
    */
    @Test
    void startFollowingOk() {
        // arrange
        when(userRepo.findById(1)).thenReturn(follower);
        when(userRepo.findById(2)).thenReturn(followed);

        // act
        ResponseDTO response = userService.startFollowing(1, 2);

        //assert
        verify(userRepo, atLeast(2)).findById(anyLong());
        assertEquals("1 successfully followed 2", response.getMessage());
    }

    /*
     * Verifies that startFollowing() throws a BadRequestException when trying to follow the same user.
    */
    @Test
    void startFollowing_SameUser() {
        //act & assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> userService.startFollowing(1, 1));
        assertEquals("User can't add themselves.", exception.getMessage());
    }

    /*
    * Verifies that startFollowing() throws a NotFoundException when the user is not found.
    */
    @Test
    void startFollowing_UserNotFound() {
        //arrange
        when(userRepo.findById(1)).thenReturn(null);

        //act & assert
        NotFoundException exception = assertThrows(NotFoundException.class, () -> userService.startFollowing(1, 2));
        assertEquals("User not found", exception.getMessage());
    }

    /*
    * Verifies that startFollowing() throws a BadRequestException when the user is not a seller.
    */
    @Test
    void startFollowing_UserNotSeller() {
        // arrange
        when(userRepo.findById(1)).thenReturn(follower);
        when(userRepo.findById(2)).thenReturn(follower2);

        // act & assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> userService.startFollowing(1, 2));
        assertEquals("User is not seller.", exception.getMessage());
    }

    /*
    * Verifies that startFollowing() throws a BadRequestException when trying to follow a user that is already being followed.
    */
    @Test
    void startFollowing_AlreadyFollowed() {
        // arrange
        follower.addFollowed(followed);
        when(userRepo.findById(1)).thenReturn(follower);
        when(userRepo.findById(2)).thenReturn(followed);

        // act & assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> userService.startFollowing(1, 2));
        assertEquals("User cant follow the same seller more than once.", exception.getMessage());
    }

    //T-0002
    /**
     * This test verifies that stopFollowing() correctly returns a responseDTO.
     * It also checks that the followed user no longer has followers.
     */
    @Test
    void stopFollowingTestOk() {
        //Arrange
        when(userRepo.findById(1L)).thenReturn(follower);
        when(userRepo.findById(2L)).thenReturn(followed);
        userService.startFollowing(1, 2);

        //Act
        ResponseDTO response = userService.stopFollowing(1, 2);

        //Assert
        assertEquals(new ResponseDTO("1 successfully unfollowed 2"), response);
        assertEquals(0, followed.getFollowers().size());
    }


    /**
     * This tests verifies that a follower can't follow themselves.
     */
    @Test
    void stopFollowingCantUnfollowThemselvesTestFail() {
        //Act & Assert
        Exception exception = assertThrows(BadRequestException.class, () -> {
            userService.stopFollowing(1, 1);
        });
        assertEquals("User can't unfollow themselves.", exception.getMessage());
    }

    /**
     * This test verifies that a user only can stop following another
     * user that it was already following.
     */
    @Test
    void stopFollowingCantUnfollowIfDidntFollowTestFail() {
        //Arrange
        when(userRepo.findById(1L)).thenReturn(follower);
        when(userRepo.findById(2L)).thenReturn(followed);

        //Act & Assert
        Exception exception = assertThrows(BadRequestException.class, () -> {
            userService.stopFollowing(1, 2);
        });
        assertEquals("You are not a follower of this user.", exception.getMessage());
    }

    /**
     * This test verifies that the followed user pops followers correctly.
     */
    @Test
    void userPopsFollowerTestOk() {
        //Arrange
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
        when(userRepo.findById(1L)).thenReturn(follower);
        when(userRepo.findById(2L)).thenReturn(followed);
        userService.startFollowing(1, 2);

        //Act
        follower.popFollowed(followed);

        //Assert
        Assertions.assertTrue(follower.getFollowed().isEmpty());
    }

    // T-0007
    /**
     * This test verifies that userService correctly counts the number of followers.
     */
    @Test
    void getNumberOfFollowersTestOk() {
        //Arrange
        when(userRepo.findById(1L)).thenReturn(followed);
        when(userRepo.findById(2L)).thenReturn(follower);
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

    /**
     * This test verifies that the number of followers of a user without followers is zero.
     */
    @Test
    void getNumberOfFollowersEmptyTestOk() {
        //Arrange
        when(userRepo.findById(1L)).thenReturn(followed);

        //Act
        NumberOfFollowersDTO numberDto = userService.getNumberOfFollowers(1);

        //Assert
        Assertions.assertEquals(0, numberDto.getFollowers_count());
    }

    /**
     * This test verifies that a NotFoundException is correctly thrown when
     * userService searches for the number of followers of a non-existent user.
     */
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

    // T-0003
    @Test
    void getFollowersExists(){

        User expectedUser = new User(1,"userPedro",null,null,new ArrayList<>());
        List<User> followersExpected = new ArrayList<>();

        when(userRepo.findById(expectedUser.getUserId())).thenReturn(expectedUser);
        when(userRepo.findFollowers((int) expectedUser.getUserId())).thenReturn(followersExpected);

        userService.getFollowers(1,"name_asc");

        verify(userRepo, Mockito.atLeastOnce()).findFollowers(1);
    }

    // T-0003
    @Test
    public void testFindFollowersMethodNonExistence() {

        User expectedUser = new User(1,"userPedro",null,null,new ArrayList<>());
        List<User> followersExpected = new ArrayList<>();

        when(userRepo.findById(expectedUser.getUserId())).thenReturn(expectedUser);
        when(userRepo.findFollowers((int) expectedUser.getUserId())).thenReturn(followersExpected);

        assertThrows(BadRequestException.class, () ->   userService.getFollowers(1, "fake"));
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