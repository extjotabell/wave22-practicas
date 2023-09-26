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
        @DisplayName("Test con order ASC OK")
        void getListPostsFromSellersFollowedOrderOkTest(){
            User userParam = UserGenerator.getUserWithListFollowed();
            User followedUser = userParam.getFollowed().get(0);
            List<Post> posts = PostGenerator.postGenerator(followedUser);
            List<PostDto> postExpected = PostGenerator.postDtoGenerator();

            Mockito.when(userRepository.findUsersById(userParam.getId())).thenReturn(userParam);
            Mockito.when(postRepository.findPostAll()).thenReturn(posts);
            List<PostDto> obtained = postService.getListPostsFromSellersFollowed(userParam.getId(), "date_asc");

            Assertions.assertEquals(postExpected, obtained);
        }

        @Test
        @DisplayName("Test RequestParamInvalidException order invalido")
        void getListPostsFromSellersFollowedOrderRequestParamExceptionTest(){
            User userParam = UserGenerator.getUserWithListFollowed();
            User followedUser = userParam.getFollowed().get(0);
            List<Post> posts = PostGenerator.postGenerator(followedUser);

            Mockito.when(userRepository.findUsersById(userParam.getId())).thenReturn(userParam);
            Mockito.when(postRepository.findPostAll()).thenReturn(posts);

            Assertions.assertThrows(RequestParamInvalidException.class,
                    () -> postService.getListPostsFromSellersFollowed(userParam.getId(),"XXX"));
        }

        @Test
        @DisplayName("Test NotFoundException por lista vacia")
        void getListPostsFromSellersFollowedOrderNotFoundExceptionTest(){
            User userParam = UserGenerator.getUserWithListFollowed();
            List<Post> emptyPosts = new ArrayList<>();

            Mockito.when(userRepository.findUsersById(userParam.getId())).thenReturn(userParam);
            Mockito.when(postRepository.findPostAll()).thenReturn(emptyPosts);

            Assertions.assertThrows(NotFoundException.class,
                    () -> postService.getListPostsFromSellersFollowed(userParam.getId(),"XXX"));
        }
    }

}
