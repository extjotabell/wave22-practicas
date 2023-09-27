package com.example.be_java_hisp_w22_g02.service.Implementations;

import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.entity.Product;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.repository.Implementations.UserRepositoryImpl;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceImplTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepositoryImpl();
    }


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
    @DisplayName("T-0005 - Test for the US-009")
    @Test
    void shouldVerifyValidOrderDateExists() {
        // ARRANGE
        User userWithPosts = userRepository.findById(1);
        User userFollower = userRepository.findById(2);
        List<Product> products = generateProducts();
        List<Post> posts = generatePosts(userWithPosts.getUserId(), products.get(0));
        userRepository.addPostToUser(posts.get(0), userWithPosts.getUserId());
        userRepository.addPostToUser(posts.get(1), userWithPosts.getUserId());
        userRepository.followUser(userFollower.getUserId(), userWithPosts.getUserId());

        // ACT & ASSERT (Caso 1: Ordenamiento válido)
        assertDoesNotThrow(() -> {
            List<Post> expectedAscPosts = userRepository.getFollowedPostLasTwoWeeks(userFollower.getUserId());
            assertEquals("2023-09-26", expectedAscPosts.get(0).getDate().toString());
        });

        // ACT & ASSERT (Caso 2: Ordenamiento no válido - Debe lanzar una excepción)
        assertThrows(IndexOutOfBoundsException.class, () -> {
            List<Post> expectedAscPosts = userRepository.getFollowedPostLasTwoWeeks(userFollower.getUserId());
            expectedAscPosts.get(0).setDate(LocalDate.parse("2023-02-26")); // Modificamos un elemento de la lista
        });

    }

    private List<Post> generatePosts(int userId, Product product) {

        Post postDTO = Post.builder()
                .postId(1)
                .userId(userId)
                .date(LocalDate.parse("2023-09-26"))
                .product(product)
                .category(1)
                .price(2000)
                .build();

        Post postDTO2 = Post.builder()
                .postId(2)
                .userId(userId)
                .date(LocalDate.parse("2023-03-20"))
                .product(product)
                .category(1)
                .price(2000)
                .build();

        return List.of(postDTO, postDTO2);
    }

    private List<Product> generateProducts() {
        Product productDto = Product.builder()
                .productId(1)
                .productName("name")
                .type("type")
                .brand("brand")
                .color("color")
                .notes("notes")
                .build();
        return List.of(productDto);
    }
}