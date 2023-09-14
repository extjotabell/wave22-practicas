package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.entity.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;

@Repository
public class PostRepositoryImp implements IPostRepository {
    private List<Post> posts = new ArrayList<>();
    private int nextPostId = 1;

    public PostRepositoryImp() {

        ProductRepositoryImp products = new ProductRepositoryImp();
        // Objeto random para asignar de forma aleatoria el post al id de un usuario
        Random random = new Random();

        // Recorre los productos falsos y asigna cada uno a un post
        for (Product product : products.getAllProducts()){

            // Genera un número aleatorio entre 1 y 3. Este numero representa el id del usuario(vendedor) al que le pertenece el post
            int idUser = random.nextInt(3) + 1;

            // Número random para la categoria
            int category = random.nextInt(99) + 1;

            // Número random para el precio
            int price = random.nextInt(3000) + 1;

            Post post = new Post(idUser, this.nextPostId++, LocalDate.now(), product, category, price);
            this.posts.add(post);
        }

    }

    @Override
    public List<Post> getAllPosts() {
        return new ArrayList<>(this.posts);
    }

    @Override
    public Post getPostById(int postId) {
        for (Post post : this.posts) {
            if (post.getPost_id() == postId) {
                return post;
            }
        }
        return null;
    }

    @Override
    public void addPost(Post post) {
        post.setPost_id(this.nextPostId++);
        this.posts.add(post);
    }

    @Override
    public void updatePost(int postId, Post updatedPost) {
        for (int i = 0; i < this.posts.size(); i++) {
            Post post = this.posts.get(i);
            if (post.getPost_id() == postId) {
                updatedPost.setPost_id(postId);
                this.posts.set(i, updatedPost);
                return;
            }
        }
    }

    @Override
    public void deletePost(int postId) {
        this.posts.removeIf(post -> post.getPost_id() == postId);
    }
}