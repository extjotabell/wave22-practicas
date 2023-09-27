package com.example.be_java_hisp_w22_g02.repository.Implementations;

import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.entity.Product;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import org.apache.commons.collections4.CollectionUtils;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryImplTest {

    @Autowired
    IUserRepository userRepository;

    @Test
    void findById() {
    }

    @Test
    void followUser() {
    }

    @Test
    @DisplayName("T008 - Get posts in the last two weeks - getFollowedPostLasTwoWeeks")
    void getFollowedPostLasTwoWeeks() {
        // Arrange
        User u1 = userRepository.findById(1);
        Product product1 = new Product(1, "Remera", "Ropa", "Marca", "Negro", null);
        Product product2 = new Product(2, "Remera", "Ropa", "Marca", "Blanco", null);
        List<Post> posts = List.of(
                new Post(1, 1, LocalDate.now(), product1, 1, 10.0),
                new Post(2, 1, LocalDate.now().minusDays(4), product2, 1, 10.0),
                new Post(3, 1, LocalDate.now().minusDays(20), product2, 1, 10.0)
        );
        u1.setPosts(posts);
        int userId = 10;
        userRepository.followUser(userId,1);

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
    @DisplayName("T006 - Ordered correctly by date ASC - getFollowedPostLasTwoWeeksOrd")
    void getFollowedPostLasTwoWeeksOrd_dateAsc_Ok() {
        // Arranged
        User u1 = userRepository.findById(1);
        Product product1 = new Product(1, "Remera", "Ropa", "Marca", "Negro", null);
        Product product2 = new Product(2, "Remera", "Ropa", "Marca", "Blanco", null);
        List<Post> posts = List.of(
                new Post(1, 1, LocalDate.now(), product1, 1, 10.0),
                new Post(2, 1, LocalDate.now().minusDays(4), product2, 1, 10.0),
                new Post(3, 1, LocalDate.now().minusDays(20), product2, 1, 10.0)
        );
        u1.setPosts(posts);

        int userId = 10;
        userRepository.followUser(userId,1);

        // Act
        List<Post> orderedList = userRepository.getFollowedPostLasTwoWeeksOrd(userId, "date_asc");

        // Assert
        assertEquals(orderedList.get(0).getDate(), LocalDate.now().minusDays(4));

    }
    @Test
    @DisplayName("T006 - Ordered correctly by date DESC - getFollowedPostLasTwoWeeksOrd")
    void getFollowedPostLasTwoWeeksOrd_dateDesc_Ok() {
        // Arrange
        User u1 = userRepository.findById(1);
        Product product1 = new Product(1, "Remera", "Ropa", "Marca", "Negro", null);
        Product product2 = new Product(2, "Remera", "Ropa", "Marca", "Blanco", null);
        List<Post> posts = List.of(
                new Post(1, 1, LocalDate.now(), product1, 1, 10.0),
                new Post(2, 1, LocalDate.now().minusDays(4), product2, 1, 10.0),
                new Post(3, 1, LocalDate.now().minusDays(20), product2, 1, 10.0)
        );
        u1.setPosts(posts);

        int userId = 10;
        userRepository.followUser(userId,1);

        // Act
        List<Post> orderedList = userRepository.getFollowedPostLasTwoWeeksOrd(userId, "date_desc");

        // Assert
        assertEquals(orderedList.get(0).getDate(), LocalDate.now());

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