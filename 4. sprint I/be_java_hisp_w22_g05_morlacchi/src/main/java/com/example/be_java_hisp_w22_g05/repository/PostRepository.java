package com.example.be_java_hisp_w22_g05.repository;

import com.example.be_java_hisp_w22_g05.entity.Post;
import com.example.be_java_hisp_w22_g05.entity.Product;
import com.example.be_java_hisp_w22_g05.entity.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class PostRepository implements IPostRepository {
    private List<Post> database = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();

    //Arranca en 4 ya que existen 3 posts. Si se borran estos, debe arrancar en 0
    int idCounter = 4;

    public PostRepository() {
        Product product1 = new Product(1, "arroz", "comida", "Gallo", "blanco", "");
        Product product2 = new Product(2, "mouse", "IT", "Logitech", "Negro", "");
        User carlos = new User(1, "carlos", new ArrayList<>(), new ArrayList<>());
        User maria = new User(2, "maria", new ArrayList<>(), new ArrayList<>());
        User pedro = new User(3, "pedro", new ArrayList<>(), new ArrayList<>());

        Post post1 = new Post(1, LocalDate.of(2023, 5, 10), 1, carlos, product1, 200.0, false, 0.0);
        //Post post2 = new Post(2, LocalDate.of(2020, 10, 12), 2, maria, product2, 1200.0, false, 0.0);
        Post post3 = new Post(3, LocalDate.of(2023, 9, 11), 3, pedro, product2, 2500.0, false, 0.0);

        productList.add(product1);
        productList.add(product2);

        database.add(post1);
        //database.add(post2);
        database.add(post3);
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

    @Override
    public Post save(Post post) {

        //Verifica que no exista un producto con ese id
        if(productExists(post.getProduct().getId())) return null;
        productList.add(post.getProduct());
        //Setea el id del post y lo agrega a la lista
        post.setId(idCounter);
        database.add(post);

        idCounter++;

        return post;
    }

    private boolean productExists(int id) {
        return productList.stream().anyMatch(product -> product.getId() == id);
    }
}
