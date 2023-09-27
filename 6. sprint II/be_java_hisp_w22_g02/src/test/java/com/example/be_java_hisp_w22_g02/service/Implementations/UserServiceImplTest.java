package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceImplTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void followUser() {
    }

    @Test
    void getFollowers() {
    }

    @Test
    @DisplayName("T0007 - Validate followers count is correct - getTotalFollowersByUserId")
    void getTotalFollowersByUserId_OkTest() {

        //Arrange
        User user = new User(1, "user1", List.of(2, 3, 4), List.of(), List.of());
        when(userRepository.existingUserById(anyInt())).thenReturn(true);
        when(userRepository.findById(anyInt())).thenReturn(user);
        int expected = user.getFollowers().size();

        //Act
        int actual = userService.getTotalFollowersByUserId(user.getUserId()).getFollowersCount();

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void unfollowUser() {
    }

    @Test
    void getFollowed() {
    }

    @Test
    void addUserPost() {
    }

    @Test
    void getLastTwoWeeksPostByUser() {
    }
}