package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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
    void getTotalFollowersByUserId() {
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