package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.response.SuccessDTO;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.exception.BadRequestException;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import java.util.List;


import static com.example.be_java_hisp_w22_g02.enums.ResponseMessages.SUCCESSFUL_FOLLOW;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName(value="Caso de exito T001")
    void followUser() {
        //ARRANGE
        int id = 1;
        int idToFollow = 2;
        List<Integer> follow = new ArrayList<>();
        follow.add(5);
        User user = new User(1,"test",follow,follow,null);

        when(userRepository.findById(any())).thenReturn(user);
        when(userRepository.existingUserById(any())).thenReturn(true);

         //ACT
        SuccessDTO actual = userService.followUser(id,idToFollow);

        //ASSERT
        assertEquals(SUCCESSFUL_FOLLOW.toString(),actual.getMessage());
    }
    @Test
    @DisplayName(value="Caso de fallo al pasar un id inexistente T001")
    void followUserWithIdNotFound() {

        assertThrows(NotFoundException.class,()->userService.followUser(1,2));
    }

    @Test
    @DisplayName(value="Caso de fallo al pasar un id inexistente T001")
    void followUserWithIdNotFoundToFollow() {
        when(userRepository.existingUserById(1)).thenReturn(true);

        assertThrows(NotFoundException.class,()->userService.followUser(1,2));
    }

    @Test
    @DisplayName(value="Caso de fallo al pasar el mismo id T001")
    void followUserWithSameId() {
        //ARRANGE
        when(userRepository.existingUserById(any())).thenReturn(true);

        assertThrows(BadRequestException.class,()->userService.followUser(1,1));
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