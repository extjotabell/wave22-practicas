package com.w22_g03.be_java_hisp_w22_g03.repository;

import com.w22_g03.be_java_hisp_w22_g03.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserRepositoryImplTest {
    @InjectMocks
    UserRepositoryImpl userRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById() {
    }

    @Test
    void findFollowerOk() {
        User user = userRepository.findFollower(3, 1);
        Assertions.assertEquals(1, user.getUserId());
        Assertions.assertEquals("Alejandro", user.getUsername());
    }

    @Test
    void findFollowers_DontHaveFollowers() {
        User user = userRepository.findFollower(1, 3);
        Assertions.assertEquals(null, user);
    }

    @Test
    void findFollowed() {
    }

    @Test
    void savePost() {
    }

    @Test
    void findAll() {
    }
}