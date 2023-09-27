package com.example.be_java_hisp_w22_g02.repository.Implementations;

import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.entity.Product;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryImplTest {

    @Autowired
    IUserRepository userRepository;

    @BeforeEach
    void SetUp (){
        User u1 = userRepository.findById(1);
        Product product1 = new Product(1, "Remera", "Ropa", "Marca", "Negro", null);
        Product product2 = new Product(2, "Remera", "Ropa", "Marca", "Blanco", null);
        List<Post> posts = List.of(
                new Post(1, 1, LocalDate.now(), product1, 1, 10.0),
                new Post(2, 1, LocalDate.now().minusDays(4), product2, 1, 10.0),
                new Post(3, 1, LocalDate.now().minusDays(20), product2, 1, 10.0)
        );
        u1.setPosts(posts);
        userRepository.followUser(10,1);
    }

    @Test
    void findById() {
    }

    @Test
    void followUser() {
    }

    @Test
    @DisplayName("Get posts in the last two weeks")
    void getFollowedPostLasTwoWeeks() {
        // Arrange
        int userId = 10;

        Product product1 = new Product(1, "Remera", "Ropa", "Marca", "Negro", null);
        Product product2 = new Product(2, "Remera", "Ropa", "Marca", "Blanco", null);

        List<Post> postsExpected = List.of(
                new Post(1, 1, LocalDate.now(), product1, 1, 10.0),
                new Post(2, 1, LocalDate.now().minusDays(4), product2, 1, 10.0)
        );

        // Act
        List<Post> actualPostList = userRepository.getFollowedPostLasTwoWeeks(userId);

        // Assert
        assertEquals(postsExpected, actualPostList);
    }

    @Test
    void getFollowedPostLasTwoWeeksOrd() {
    }

    @Test
    void existingUserById() {
    }

    @Test
    void unFollowUser() {
    }

    @Test
    void addPostToUser() {
    }
}