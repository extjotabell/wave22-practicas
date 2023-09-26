package com.w22_g03.be_java_hisp_w22_g03.controller;

import com.w22_g03.be_java_hisp_w22_g03.dto.ResponseDTO;
import com.w22_g03.be_java_hisp_w22_g03.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    @Test
    void followASellerOk() {
        // arrange
        when(userService.startFollowing(anyInt(), anyInt())).thenReturn(new ResponseDTO("Seguido correctamente"));

        // act
        ResponseEntity<?> responseEntity = userController.followASeller(1, 2);

        // assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(userService, atLeastOnce()).startFollowing(1, 2);

    }
}