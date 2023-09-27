package com.w22_g03.be_java_hisp_w22_g03.util;

import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.model.Product;
import com.w22_g03.be_java_hisp_w22_g03.model.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestUtilGenerator {
    public static User createTestUser(long userId, String username) {
        return new User(userId, username, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public static User createTestUserSeller(long userId, String username) {
        User seller = createTestUser(userId, username);
        Product product = createTestProduct(1, "Producto 1", null);
        Post post = createTestPost(1, seller, LocalDate.now(), product);
        Post post2 = createTestPost(2, seller, LocalDate.now().minusDays(14), product);
        seller.getPosts().add(post);
        seller.getPosts().add(post2);
        return seller;
    }

    public static Product createTestProduct(long productId, String productName, Post post) {
        return new Product(productId, productName, "Tipo", "Marca", "Color", "Notas", post);
    }

    public static Post createTestPost(long postId, User user, LocalDate date, Product product) {
        return new Post(postId, user, date, product, 1, 50.0, true, 10.0);
    }
}
