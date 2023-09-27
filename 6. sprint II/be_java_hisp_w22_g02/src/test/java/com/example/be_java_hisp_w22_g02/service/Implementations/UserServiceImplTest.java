package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.dto.response.TwoWeeksPostDTO;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
    @DisplayName("T-0005 Success - Test for the US-009")
    @Test
    void shouldVerifyValidOrderDateExists() {
        // ARRANGE
        when(userRepository.existingUserById(2)).thenReturn(true);
        List<TwoWeeksPostDTO> expectedAscPosts = new ArrayList<>();
        // ACT
        TwoWeeksPostDTO postTest = userService.getLastTwoWeeksPostByUser(2, "date_asc");
        expectedAscPosts.add(postTest);
        // ASSERT
        assertNotNull(postTest.getPosts());
    }
}