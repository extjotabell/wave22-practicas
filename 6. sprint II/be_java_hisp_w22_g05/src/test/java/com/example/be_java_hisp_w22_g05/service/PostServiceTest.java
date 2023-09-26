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
import com.example.be_java_hisp_w22_g05.Datos;
import com.example.be_java_hisp_w22_g05.dto.ProductDto;
import com.example.be_java_hisp_w22_g05.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


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

    @Test
    @DisplayName("Verificar el correcto ordenamiento ascendente por Fecha")
    void getListPostsFromSellersFollowedOrderAscOkTest() {

        // ARRANGE
        String order = "date_asc";
        User userParam = Datos.getUser();
        User userFollowed = userParam.getFollowed().get(0);
        List<Post> postList = Datos.getPostList(userFollowed);
        List<PostDto> expected = Datos.getPostDtoListAsc();

        // ACT
        when(userRepository.findUsersById(userParam.getId())).thenReturn(userParam);

        when(postRepository.findPostAll()).thenReturn(postList);

        List<PostDto> actual = postService.getListPostsFromSellersFollowed(userParam.getId(), order);

        // ASSERT
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Verificar el correcto ordenamiento Descendente por Fecha")
    void getListPostsFromSellersFollowedOrderDescOkTest() {

        // ARRANGE
        String order = "date_desc";
        User userParam = Datos.getUser();
        User userFollowed = userParam.getFollowed().get(0);
        List<Post> postList = Datos.getPostList(userFollowed);
        List<PostDto> expected = Datos.getPostDtoListDesc();
        // ACT

        when(userRepository.findUsersById(userParam.getId())).thenReturn(userParam);

        when(postRepository.findPostAll()).thenReturn(postList);

        List<PostDto> actual = postService.getListPostsFromSellersFollowed(userParam.getId(), order);

        // ASSERT

        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("T0008: Test para US0006")
    void getListPostsFromSellersFollowedOkTest(){
        //Arrange
        List<Post> postList = new ArrayList<>();
        User carlos = new User(1,"carlos",new ArrayList<>(),new ArrayList<>());
        User maria = new User(2,"maria",new ArrayList<>(),new ArrayList<>());

        carlos.getFollower().add(maria);
        maria.getFollowed().add(carlos);

        Product product1 = new Product(1, "arroz", "comida", "Gallo", "blanco", "");
        Product product2 = new Product(2, "mouse", "IT", "Logitech", "Negro", "");

        Post post1 = new Post(1, LocalDate.now().minusDays(13), 1, carlos, product1, 200.0, null, null);
        Post post2 = new Post(2, LocalDate.now().minusDays(14), 2, carlos, product2, 1200.0, null, null);
        Post post3 = new Post(3, LocalDate.now().minusDays(15), 3, carlos, product2, 2500.0, null, null);

        postList.add(post1);
        postList.add(post2);
        postList.add(post3);

        ProductDto productDto1 = new ProductDto(1, "arroz", "comida", "Gallo", "blanco", "");
        ProductDto productDto2 = new ProductDto(2, "mouse", "IT", "Logitech", "Negro", "");

        List<PostDto> postDtoList = new ArrayList<>();
        postDtoList.add(new PostDto(1, carlos.getId(), post1.getDate(),
                productDto1, post1.getCategory(), post1.getPrice(), post1.getHasPromo(),
                post1.getDiscount()));

        postDtoList.add(new PostDto(2, carlos.getId(), post2.getDate(),
                productDto2, post2.getCategory(), post2.getPrice(), post2.getHasPromo(),
                post2.getDiscount()));

        when(postRepository.findPostAll()).thenReturn(postList);
        when(userRepository.findUsersById(2)).thenReturn(maria);
        //Act & Assert
        Assertions.assertEquals(postDtoList,
                postService.getListPostsFromSellersFollowed(2, "date_desc"));
    }
}
