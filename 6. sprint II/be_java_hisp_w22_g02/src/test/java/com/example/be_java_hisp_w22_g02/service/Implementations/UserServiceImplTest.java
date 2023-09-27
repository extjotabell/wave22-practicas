package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.exception.BadRequestException;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

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
    @DisplayName("T0003 - Validate OK ascending alphabetic order - getFollowers")
    void getFollowers_OrderByNameAsc_ExistsTest() {

        //Arrange
        when(userRepository.existingUserById(anyInt())).thenReturn(true);
        when(userRepository.findById(anyInt())).thenReturn(new User());

        //Act
        userService.getFollowers(1, "name_asc");

        //Assert
        verify(userRepository, atLeastOnce()).findById(anyInt());

    }

    @Test
    @DisplayName("T0003 - Validate OK descending alphabetic order - getFollowers")
    void getFollowers_OrderByNameDesc_ExistsTest() {

        //Arrange
        when(userRepository.existingUserById(anyInt())).thenReturn(true);
        when(userRepository.findById(anyInt())).thenReturn(new User());

        //Act
        userService.getFollowers(1, "name_desc");

        //Assert
        verify(userRepository, atLeastOnce()).findById(anyInt());

    }

    @Test
    @DisplayName("T0003 - Validate exception when order is invalid - getFollowers")
    void getFollowers_OrderByName_NotExistTest() {

        //Arrange
        when(userRepository.existingUserById(anyInt())).thenReturn(true);
        when(userRepository.findById(anyInt())).thenReturn(new User());

        //Act & Assert
        assertThrows(BadRequestException.class, () -> userService.getFollowers(1, "name_ascc"));

    }

    @Test
    @DisplayName("T0003 - Validate OK ascending alphabetic order - getFollowed")
    void getFollowed_OrderByNameAsc_ExistsTest() {

        //Arrange
        when(userRepository.existingUserById(anyInt())).thenReturn(true);
        when(userRepository.findById(anyInt())).thenReturn(new User());

        //Act
        userService.getFollowed(1, "name_asc");

        //Assert
        verify(userRepository, atLeastOnce()).findById(anyInt());

    }

    @Test
    @DisplayName("T0003 - Validate OK descending alphabetic order - getFollowed")
    void getFollowed_OrderByNameDesc_ExistsTest() {

        //Arrange
        when(userRepository.existingUserById(anyInt())).thenReturn(true);
        when(userRepository.findById(anyInt())).thenReturn(new User());

        //Act
        userService.getFollowed(1, "name_desc");

        //Assert
        verify(userRepository, atLeastOnce()).findById(anyInt());

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