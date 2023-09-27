package com.example.be_java_hisp_w22_g02.repository.Implementations;

import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.entity.Product;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    void getFollowedPostLasTwoWeeks() {
    }

    @Test
    void getFollowedPostLasTwoWeeksOrd_dateAsc_Ok() {
        // Arrange
        User u1 = userRepository.findById(1);
        Product product1 = new Product(1, "Remera", "Ropa", "Marca", "Negro", null);
        Product product2 = new Product(2, "Remera", "Ropa", "Marca", "Blanco", null);
        List<Post> posts = List.of(
                new Post(1, 1, LocalDate.now(), product1, 1, 10.0),
                new Post(1, 1, LocalDate.now().minusDays(4), product2, 1, 10.0)
        );
        u1.setPosts(posts);
        userRepository.followUser(10,1);

        // Act
        List<Post> orderedList = userRepository.getFollowedPostLasTwoWeeksOrd(10, "date_asc");

        // Assert
        assertEquals(orderedList.get(0).getDate(), LocalDate.now().minusDays(4));

    }
    @Test
    void getFollowedPostLasTwoWeeksOrd_dateDesc_Ok() {
        // Arrange
        User u1 = userRepository.findById(1);
        Product product1 = new Product(1, "Remera", "Ropa", "Marca", "Negro", null);
        Product product2 = new Product(2, "Remera", "Ropa", "Marca", "Blanco", null);
        List<Post> posts = List.of(
                new Post(1, 1, LocalDate.now(), product1, 1, 10.0),
                new Post(1, 1, LocalDate.now().minusDays(4), product2, 1, 10.0)
        );
        u1.setPosts(posts);
        userRepository.followUser(10,1);

        // Act
        List<Post> orderedList = userRepository.getFollowedPostLasTwoWeeksOrd(10, "date_desc");

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