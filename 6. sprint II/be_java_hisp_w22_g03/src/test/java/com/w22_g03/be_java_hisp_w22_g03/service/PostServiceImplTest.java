package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.UserFollowedSellersPostsDTO;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import com.w22_g03.be_java_hisp_w22_g03.repository.PostRepository;
import com.w22_g03.be_java_hisp_w22_g03.repository.PostRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PostServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private PostServiceImpl postService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addPost() {
    }

    @Test
    void getFollowedUsersPostsByIdWithNoPostsWithDescendingOrderReturnEmptyListOk() {
        long userId = 1L;
        when(userService.getUserById(userId)).thenReturn(new User(userId, "user1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        UserFollowedSellersPostsDTO userFollowedSellersPostsDTO = postService.getFollowedUsersPostsById(userId, "date_desc");

        assertEquals(0, userFollowedSellersPostsDTO.getPosts().size());
    }

    @Test
    void getFollowedUsersPostsByIdWithNoPostsWithAscendingOrderReturnEmptyListOk() {
        long userId = 1L;
        when(userService.getUserById(userId)).thenReturn(new User(userId, "user1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        UserFollowedSellersPostsDTO userFollowedSellersPostsDTO = postService.getFollowedUsersPostsById(userId, "date_asc");

        assertEquals(0, userFollowedSellersPostsDTO.getPosts().size());
    }

    @Test
    void getAllFollowedUsersPostsById() {
    }

    @Test
    void testGetFollowedUsersPostsById() {
    }
}