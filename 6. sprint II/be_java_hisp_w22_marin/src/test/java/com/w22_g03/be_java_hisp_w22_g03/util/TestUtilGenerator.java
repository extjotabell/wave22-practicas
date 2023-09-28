package com.w22_g03.be_java_hisp_w22_g03.util;

import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.model.Product;
import com.w22_g03.be_java_hisp_w22_g03.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestUtilGenerator {
    public static User createTestUser(long userId, String username) {
        return new User(userId, username, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }
    public static User createTestUserSeller(long userId, String username) {
        User seller = new User(userId, username, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Product product = createTestProduct(1, "Producto 1", null);
        Post post = createTestPost(1, seller, LocalDate.of(2023, 9, 26), product);
        seller.setPosts(List.of(post));
        return seller;
    }
    public static Product createTestProduct(long productId, String productName, Post post) {
        return new Product(productId, productName, "Tipo", "Marca", "Color", "Notas", post);
    }

    public static Post createTestPost(long postId, User user, LocalDate date, Product product) {
        return new Post(postId, user, date, product, 1, 50.0, true, 10.0);
    }

}
