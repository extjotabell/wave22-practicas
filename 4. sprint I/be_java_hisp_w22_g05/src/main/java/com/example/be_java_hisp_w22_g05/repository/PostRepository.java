package com.example.be_java_hisp_w22_g05.repository;

import com.example.be_java_hisp_w22_g05.entity.Post;
import com.example.be_java_hisp_w22_g05.entity.Product;
import com.example.be_java_hisp_w22_g05.entity.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepository implements IPostRepository {
    private List<Post> database = new ArrayList<>();

    public PostRepository() {
        Product product1 = new Product(1, "arroz", "comida", "Gallo", "blanco", "");
        Product product2 = new Product(2, "mouse", "IT", "Logitech", "Negro", "");
        User carlos = new User(1, "carlos", new ArrayList<>(), new ArrayList<>());
        User maria = new User(2, "maria", new ArrayList<>(), new ArrayList<>());
        User pedro = new User(3, "pedro", new ArrayList<>(), new ArrayList<>());

        Post post1 = new Post(1, LocalDate.of(2023, 9, 10), 1, carlos, product1, 200.0, false, 0.0);
        Post post2 = new Post(2, LocalDate.of(2020, 10, 12), 2, maria, product2, 1200.0, false, 0.0);
        Post post3 = new Post(3, LocalDate.of(2023, 9, 11), 3, pedro, product2, 2500.0, false, 0.0);
    }

    @Override
    public Post findPostById(int id) {
        return database.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseGet(() -> null);
    }

    @Override
    public List<Post> findPostAll() {
        return database;
    }
}
