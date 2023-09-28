package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.ProductDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.UserFollowedSellersPostsDTO;
import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.model.Product;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import com.w22_g03.be_java_hisp_w22_g03.repository.PostRepository;
import com.w22_g03.be_java_hisp_w22_g03.repository.PostRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    void getFollowedUsersPostsByIdWithDescendingOrderReturnListOrderedOk() {
        long userId = 1L;
        User user = new User(userId, "user1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Post lastPost = new Post(1L, user, LocalDate.now(), new Product(), 1, 10.0, false, 0.0);
        Post secondLastPost = new Post(2L, user, LocalDate.now().minusDays(1), new Product(), 1, 15.0, true, 5.0);
        Post thirdLastPost = new Post(2L, user, LocalDate.now().minusDays(7), new Product(), 1, 15.0, true, 5.0);
        List<Post> posts = Arrays.asList(
                thirdLastPost,
                secondLastPost,
                lastPost
        );
        List<PostDTO> orderedPosts = Arrays.asList(
                mapPostToPostDto(lastPost),
                mapPostToPostDto(secondLastPost),
                mapPostToPostDto(thirdLastPost)
        );
        when(userService.getUserById(userId)).thenReturn(user);
        when(postRepository.findTwoWeekOldPostsFromFollowedByUser(user)).thenReturn(posts);

        UserFollowedSellersPostsDTO userFollowedSellersPostsDTO = postService.getFollowedUsersPostsById(userId, "date_desc");
        for (int i = 0; i < userFollowedSellersPostsDTO.getPosts().size(); i++) {
            assertEquals(userFollowedSellersPostsDTO.getPosts().get(i), orderedPosts.get(i));
        }
    }

    @Test
    void getFollowedUsersPostsByIdWithAscendingOrderReturnListOrderedOk() {
        long userId = 1L;
        User user = new User(userId, "user1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Post thirdOldestPost = new Post(1L, user, LocalDate.now(), new Product(), 1, 10.0, false, 0.0);
        Post secondOldestPost = new Post(2L, user, LocalDate.now().minusDays(1), new Product(), 1, 15.0, true, 5.0);
        Post oldestPost = new Post(2L, user, LocalDate.now().minusDays(7), new Product(), 1, 15.0, true, 5.0);
        List<Post> posts = Arrays.asList(
                thirdOldestPost,
                secondOldestPost,
                oldestPost
        );
        List<PostDTO> orderedPosts = Arrays.asList(
                mapPostToPostDto(oldestPost),
                mapPostToPostDto(secondOldestPost),
                mapPostToPostDto(thirdOldestPost)
        );
        when(userService.getUserById(userId)).thenReturn(user);
        when(postRepository.findTwoWeekOldPostsFromFollowedByUser(user)).thenReturn(posts);

        UserFollowedSellersPostsDTO userFollowedSellersPostsDTO = postService.getFollowedUsersPostsById(userId, "date_asc");
        for (int i = 0; i < userFollowedSellersPostsDTO.getPosts().size(); i++) {
            assertEquals(userFollowedSellersPostsDTO.getPosts().get(i), orderedPosts.get(i));
        }
    }

    @Test
    void getAllFollowedUsersPostsById() {
    }

    @Test
    void testGetFollowedUsersPostsById() {
    }

    private  PostDTO mapPostToPostDto(Post post) {
        ModelMapper mapper = new ModelMapper();
        PostDTO postDto = mapper.map(post, PostDTO.class);
        postDto.setProduct(mapper.map(post.getProduct(), ProductDTO.class));
        postDto.setUserId(post.getUser().getUserId());
        return postDto;
    }
}