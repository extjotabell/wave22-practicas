package com.w22_g03.be_java_hisp_w22_g03.service;


import com.w22_g03.be_java_hisp_w22_g03.exception.BadRequestException;
import com.w22_g03.be_java_hisp_w22_g03.exception.NotFoundException;
import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import com.w22_g03.be_java_hisp_w22_g03.repository.PostRepository;
import com.w22_g03.be_java_hisp_w22_g03.repository.UserRepository;
import com.w22_g03.be_java_hisp_w22_g03.repository.UserRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

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

    @Test
    void stopFollowing() {
    }

    @Test
    void getNumberOfFollowers() {
    }

    @Test
    void getFollowersExists(){

        User expectedUser = new User(1,"userPedro",null,null,new ArrayList<>());
        List<User> followersExpected = new ArrayList<>();

        when(userRepo.findById(expectedUser.getUserId())).thenReturn(expectedUser);
        when(userRepo.findFollowers((int) expectedUser.getUserId())).thenReturn(followersExpected);

        userService.getFollowers(1,"name_asc");

        verify(userRepo, Mockito.atLeastOnce()).findFollowers(1);
    }

    @Test
    public void testFindFollowersMethodNonExistence() {

        User expectedUser = new User(1,"userPedro",null,null,new ArrayList<>());
        List<User> followersExpected = new ArrayList<>();

        when(userRepo.findById(expectedUser.getUserId())).thenReturn(expectedUser);
        when(userRepo.findFollowers((int) expectedUser.getUserId())).thenReturn(followersExpected);

        assertThrows(BadRequestException.class, () ->   userService.getFollowers(1, "fake"));
    }

    @Test
    void getFollowed() {
    }

    @Test
    void getFollowers() {

    }

    @Test
    void getUserById() {
    }
}