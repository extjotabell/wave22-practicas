package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.FollowedDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.FollowerDTO;
import com.w22_g03.be_java_hisp_w22_g03.exception.BadRequestException;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import com.w22_g03.be_java_hisp_w22_g03.repository.UserRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
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

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock UserRepositoryImpl userRepository;

    @InjectMocks UserServiceImpl userService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void startFollowing() {
    }

    @Test
    void stopFollowing() {
    }

    @Test
    void getNumberOfFollowers() {
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
        when(userRepository.findById(userToGetFollowers.getUserId())).thenReturn(userToGetFollowers);
        when(userRepository.findFollowers((int)userToGetFollowers.getUserId())).thenReturn(followers);
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
        when(userRepository.findById(userToGetFollowers.getUserId())).thenReturn(userToGetFollowers);
        when(userRepository.findFollowers((int)userToGetFollowers.getUserId())).thenReturn(followers);
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
        when(userRepository.findById(userToGetFollowers.getUserId())).thenReturn(userToGetFollowers);
        when(userRepository.findFollowers((int)userToGetFollowers.getUserId())).thenReturn(followers);
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
        when(userRepository.findById(userToGetFollowed.getUserId())).thenReturn(userToGetFollowed);
        when(userRepository.findFollowed((int)userToGetFollowed.getUserId())).thenReturn(followed);
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
        when(userRepository.findById(userToGetFollowed.getUserId())).thenReturn(userToGetFollowed);
        when(userRepository.findFollowed((int)userToGetFollowed.getUserId())).thenReturn(followed);
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
        when(userRepository.findById(userToGetFollowed.getUserId())).thenReturn(userToGetFollowed);
        when(userRepository.findFollowed((int)userToGetFollowed.getUserId())).thenReturn(followed);
        assertThrows(BadRequestException.class, () -> userService.getFollowed(((int) userToGetFollowed.getUserId()),invalidOrder));
    }
    
    @Test
    void getUserById() {
    }
}