package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.response.SuccessDTO;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.exception.NotFoundException;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static com.example.be_java_hisp_w22_g02.enums.ResponseMessages.*;
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
    void getTotalFollowersByUserId() {
    }

    @Test
    @DisplayName("Unfollow Existent User")
    void unfollowUserExistent() {
        //Arrange
        int idUserPrincipal = 1;
        int idUserToUnfollow = 2;
        SuccessDTO expectedSuccessDTO = new SuccessDTO(SUCCESSFUL_UNFOLLOW.toString());
        when(userRepository.existingUserById(idUserPrincipal)).thenReturn(true);
        when(userRepository.existingUserById(idUserToUnfollow)).thenReturn(true);
        when(userRepository.findById(idUserPrincipal).getFollowed().contains(idUserToUnfollow)).thenReturn(true);

        //Act
        SuccessDTO actualSuccessDTO = userService.unfollowUser(idUserPrincipal, idUserToUnfollow);

        //Assert
        assertEquals(expectedSuccessDTO, actualSuccessDTO);
    }

    @Test
    @DisplayName("Unfollow Nonexistent User")
    void unfollowUserNonExistent() {
        //Arrange
        int idUserPrincipal = 1;
        int idUserToUnfollow = 999;
        when(userRepository.existingUserById(idUserPrincipal)).thenReturn(true);
        when(userRepository.existingUserById(idUserToUnfollow)).thenReturn(false);
        when(userRepository.findById(idUserPrincipal).getFollowed().contains(idUserToUnfollow)).thenReturn(false);

        //Act

        //Assert
        assertThrows(NotFoundException.class,()->userService.unfollowUser(idUserPrincipal, idUserToUnfollow));
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