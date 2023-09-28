package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.entity.Post;
import com.example.be_java_hisp_w22_g05.entity.User;
import com.example.be_java_hisp_w22_g05.exception.NotFoundException;
import com.example.be_java_hisp_w22_g05.exception.RequestParamInvalidException;
import com.example.be_java_hisp_w22_g05.repository.IPostRepository;
import com.example.be_java_hisp_w22_g05.repository.IUserRepository;
import com.example.be_java_hisp_w22_g05.utils.PostGenerator;
import com.example.be_java_hisp_w22_g05.utils.UserGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    IPostRepository postRepository;
    @Mock
    IUserRepository userRepository;

    @InjectMocks
    PostService postService;

    @Nested
    class TS0005{
        @Test
        @DisplayName("Orden ascendente fecha OK")
        void getListPostsFromSellersFollowedOrderOkTest(){
            User userParam = UserGenerator.getUser();
            User followedUser = userParam.getFollowed().get(0);
            List<Post> posts = PostGenerator.postGenerator(followedUser);
            List<PostDto> postExpected = PostGenerator.postDtoGenerator();

            Mockito.when(userRepository.findUsersById(userParam.getId())).thenReturn(userParam);
            Mockito.when(postRepository.findPostAll()).thenReturn(posts);
            List<PostDto> obtained = postService.getListPostsFromSellersFollowed(userParam.getId(), "date_asc");

            Assertions.assertEquals(postExpected, obtained);
        }

        @Test
        @DisplayName("RequestParamInvalidException orden invalido")
        void getListPostsFromSellersFollowedOrderRequestParamExceptionTest(){
            User userParam = UserGenerator.getUser();
            User followedUser = userParam.getFollowed().get(0);
            List<Post> posts = PostGenerator.postGenerator(followedUser);

            Mockito.when(userRepository.findUsersById(userParam.getId())).thenReturn(userParam);
            Mockito.when(postRepository.findPostAll()).thenReturn(posts);

            Assertions.assertThrows(RequestParamInvalidException.class,
                    () -> postService.getListPostsFromSellersFollowed(userParam.getId(),"XXX"));
        }

        @Test
        @DisplayName("NotFoundException por lista vacia")
        void getListPostsFromSellersFollowedOrderNotFoundExceptionTest(){
            User userParam = UserGenerator.getUser();
            List<Post> emptyPosts = new ArrayList<>();

            Mockito.when(userRepository.findUsersById(userParam.getId())).thenReturn(userParam);
            Mockito.when(postRepository.findPostAll()).thenReturn(emptyPosts);

            Assertions.assertThrows(NotFoundException.class,
                    () -> postService.getListPostsFromSellersFollowed(userParam.getId(),"XXX"));
        }
    }

    @Nested
    class TS0006{
        @Test
        @DisplayName("Ordenamiento ascendente por Fecha Ok")
        void getListPostsFromSellersFollowedOrderAscOkTest() {

            // ARRANGE
            String order = "date_asc";
            User userParam = UserGenerator.getUser();
            User userFollowed = userParam.getFollowed().get(0);
            List<Post> postList = PostGenerator.getPostList(userFollowed);
            List<PostDto> expected = PostGenerator.getPostDtoListAsc();

            // ACT
            when(userRepository.findUsersById(userParam.getId())).thenReturn(userParam);

            when(postRepository.findPostAll()).thenReturn(postList);

            List<PostDto> actual = postService.getListPostsFromSellersFollowed(userParam.getId(), order);

            // ASSERT
            assertEquals(expected,actual);

        }

        @Test
        @DisplayName("Ordenamiento Descendente por Fecha OK")
        void getListPostsFromSellersFollowedOrderDescOkTest() {

            // ARRANGE
            String order = "date_desc";
            User userParam = UserGenerator.getUser();
            User userFollowed = userParam.getFollowed().get(0);
            List<Post> postList = PostGenerator.getPostList(userFollowed);
            List<PostDto> expected = PostGenerator.getPostDtoListDesc();
            // ACT

            when(userRepository.findUsersById(userParam.getId())).thenReturn(userParam);

            when(postRepository.findPostAll()).thenReturn(postList);

            List<PostDto> actual = postService.getListPostsFromSellersFollowed(userParam.getId(), order);

            // ASSERT

            assertEquals(expected,actual);

        }
    }

    @Nested
    class TS0008{
        @Test
        @DisplayName("Post de usuarios seguidos ultimas dos semanas OK")
        void getListPostsFromSellersFollowedOkTest(){
            //Arrange
            User carlos = new User(1,"carlos",new ArrayList<>(),new ArrayList<>());
            User maria = new User(2,"maria",new ArrayList<>(),new ArrayList<>());

            carlos.getFollower().add(maria);
            maria.getFollowed().add(carlos);

            when(postRepository.findPostAll()).thenReturn(PostGenerator.getPostListAroundLimitDate(carlos));
            when(userRepository.findUsersById(2)).thenReturn(maria);
            //Act & Assert
            Assertions.assertEquals(PostGenerator.getPostDTOList(carlos),
                    postService.getListPostsFromSellersFollowed(2, "date_desc"));
        }
    }

}
