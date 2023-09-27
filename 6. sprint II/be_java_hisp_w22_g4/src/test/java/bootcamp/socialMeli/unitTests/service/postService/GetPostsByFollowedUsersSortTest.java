package bootcamp.socialMeli.unitTests.service.postService;

import bootcamp.socialMeli.dto.FollowedPostListDto;
import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.entity.Post;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.repository.IPostRepository;
import bootcamp.socialMeli.service.IUserService;
import bootcamp.socialMeli.service.PostServiceImpl;
import bootcamp.socialMeli.utils.ProductOrderListEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GetPostsByFollowedUsersSortTest {
    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private IUserService userService;

    @Mock
    private IPostRepository postRepository;

    @InjectMocks
    private PostServiceImpl postService;

    @BeforeEach
    void setUp(){
        // Set newest and oldest dates;
        LocalDate today = LocalDate.now();
        LocalDate yesterday = LocalDate.now().minusDays(1);

        // Set COMPRADOR following VENDEDOR
        User userComprador = new User();
        userComprador.setUserId(6);
        userComprador.setFollowed(List.of(1));
        userComprador.setFollowers(List.of());

        // Set VENDEDOR
        User userVendedor = new User();
        userVendedor.setUserId(1);
        userVendedor.setFollowers(List.of(6));
        userVendedor.setFollowed(List.of());
        userVendedor.setPostList(List.of(1,2));

        // Set today post
        Post newestPost = new Post();
        newestPost.setDate(today);
        newestPost.setUserId(1);
        newestPost.setPostId(1);

        // Set yesterday post
        Post oldestPost = new Post();
        oldestPost.setDate(yesterday);
        oldestPost.setUserId(1);
        oldestPost.setPostId(2);

        // Set Posts DTO
        PostDto newestPostDto = new PostDto();
        newestPostDto.setDate(newestPost.getDate());

        PostDto oldestPostDto = new PostDto();
        oldestPostDto.setDate(oldestPost.getDate());

        // Find COMPRADOR user to loop VENDEDORES stored in FOLLOWED list
        when(userService.findUserById(userComprador.getUserId())).thenReturn(userComprador);
        // Find VENDEDOR (inside FOLLOWED list of COMPRADOR user)
        when(userService.findUserById(userVendedor.getUserId())).thenReturn(userVendedor);
        // Return List of posts from VENDEDOR user
        when(postRepository.getLatestPostsByUserId(anyInt())).thenReturn(List.of(newestPost, oldestPost));

        // Mocking object mapper
        when(objectMapper.convertValue(newestPost, PostDto.class)).thenReturn(newestPostDto);
        when(objectMapper.convertValue(oldestPost, PostDto.class)).thenReturn(oldestPostDto);

    }

    @Test
    @DisplayName("[T-0006 / US-0009] Get Posts by followed users sorted ASCENDANT")
    void getPostsByFollowedUsersSortAsc(){
        //Arrange
        int userCompradorId = 6;
        ProductOrderListEnum sortAsc = ProductOrderListEnum.date_asc;

        // Act
        FollowedPostListDto followedPostListDto = postService.getPostsByFollowedUsers(userCompradorId, sortAsc);

        // Assert
        Assertions.assertTrue(followedPostListDto
                .getPosts()
                .get(0)
                .getDate()
                .isBefore(followedPostListDto.getPosts().get(1).getDate())
        );
    }

    @Test
    @DisplayName("[T-0006 / US-0009] Get Posts by followed users sorted DESCENDANT")
    void getPostsByFollowedUsersSortDesc(){
        //Arrange
        int userCompradorId = 6;
        ProductOrderListEnum sortDesc = ProductOrderListEnum.date_desc;

        // Act
        FollowedPostListDto followedPostListDto = postService.getPostsByFollowedUsers(userCompradorId, sortDesc);

        // Assert
        Assertions.assertTrue(followedPostListDto
                .getPosts()
                .get(0)
                .getDate()
                .isAfter(followedPostListDto.getPosts().get(1).getDate())
        );
    }
}
