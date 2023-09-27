package com.meli.be_java_hisp_w22_g01.util;

import com.meli.be_java_hisp_w22_g01.dto.PostDTO;
import com.meli.be_java_hisp_w22_g01.dto.ProductDTO;
import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.entity.Product;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UtilTestGenerator {

    private static List<User> get3Users() {
        User user1 = new User(1, "Pepe", new ArrayList<>());
        User user2 = new User(2, "Alberto", new ArrayList<>());
        User user3 = new User(3, "Dario", new ArrayList<>());
        return List.of(user1, user2, user3);
    }

    public static List<Seller> get2SellerWithPosts() {
        List<User> users = get3Users();
        List<Post> posts = get4Posts();


        Seller seller1 = new Seller(List.of(posts.get(0), posts.get(1)), List.of(users.get(0)));
        seller1.setUser_id(4);
        seller1.setUser_name("Berna");

        Seller seller2 = new Seller(List.of(posts.get(2), posts.get(3)), List.of(users.get(1), users.get(2), users.get(0)));
        seller2.setUser_id(5);
        seller2.setUser_name("Carla");
        users.get(0).setFollowed(List.of(seller1, seller2));
        users.get(1).setFollowed(List.of(seller2));
        users.get(2).setFollowed(List.of(seller2));

        return List.of(seller1, seller2);
    }

    public static List<Product> get3Products() {
        Product product1 = new Product(1, "Prod 1", "Tipo 1", "Marca 1", "Color 1", "Nota 1");
        Product product2 = new Product(2, "Prod 2", "Tipo 1", "Marca 1", "Color 1", "Nota 2");
        Product product3 = new Product(3, "Prod 3", "Tipo 2", "Marca 2", "Color 2", "Nota 3");
        return List.of(product1, product2, product3);
    }

    public static List<ProductDTO> get3ProductsDtos() {
        ProductDTO product1 = new ProductDTO(1, "Prod 1", "Tipo 1", "Marca 1", "Color 1", "Nota 1");
        ProductDTO product2 = new ProductDTO(2, "Prod 2", "Tipo 1", "Marca 1", "Color 1", "Nota 2");
        ProductDTO product3 = new ProductDTO(3, "Prod 3", "Tipo 2", "Marca 2", "Color 2", "Nota 3");
        return List.of(product1, product2, product3);
    }

    private static List<Post> get4Posts() {
        List<Product> products = get3Products();
        Post post1 = new Post(4, 1, LocalDate.now(), products.get(0), 1, 1900);
        Post post2 = new Post(4, 2, LocalDate.now().minusDays(3), products.get(1), 1, 2400);
        Post post3 = new Post(5, 3, LocalDate.now(), products.get(0), 1, 1900);
        Post post4 = new Post(5, 4, LocalDate.now().minusDays(20), products.get(2), 1, 4500);

        return List.of(post1, post2, post3, post4);
    }

    public static List<PostDTO> get4PostsDTO() {
        List<ProductDTO> products = get3ProductsDtos();
        PostDTO post1 = new PostDTO(4, 1, LocalDate.now(), products.get(0), 1, 1900);
        PostDTO post2 = new PostDTO(4, 2, LocalDate.now().minusDays(3), products.get(1), 1, 2400);
        PostDTO post3 = new PostDTO(5, 3, LocalDate.now(), products.get(0), 1, 1900);
        PostDTO post4 = new PostDTO(5, 4, LocalDate.now().minusDays(20), products.get(2), 1, 4500);

        return List.of(post1, post2, post3, post4);
    }
}
