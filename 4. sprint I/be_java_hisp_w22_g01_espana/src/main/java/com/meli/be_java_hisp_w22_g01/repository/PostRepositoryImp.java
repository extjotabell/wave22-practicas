package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.entity.Product;
import com.meli.be_java_hisp_w22_g01.entity.PromoPost;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
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
         Product producto1= new Product(10,"Sillon","silla","sillon","rojo","nuevo");
         Post post1= new Post(2,7,LocalDate.of(2023,9,5),producto1,2,10000);
         this.posts.add(post1);

    }

    @Override
    public List<Post> getAllPosts() {
        return new ArrayList<>(this.posts);
    }

    @Override
    public Post getPostById(int postId) {
        for (Post post : this.posts) {
            if (post instanceof PromoPost) {
                return (PromoPost) post; // Si es PromoPost, devolvemos un PromoPost
            } else {
                return post; // Si es un objeto Post se devuelve este
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

    @Override
    public Boolean checkProductInPromo(int productId) {
        Optional<Post> post = this.posts.stream()
                .filter(p -> p.getProduct().getProduct_id() == productId)
                .filter(p -> p instanceof PromoPost)
                .findFirst();

        if (post.isPresent()){
            PromoPost promo = (PromoPost) post.get();
            System.out.println(promo);
            return promo.getHas_promo();
        }
        return false;
    }

    @Override
    public List<Post> getPromoPostSeller(int sellerId) {
        return posts.stream()
                .filter(p-> p.getUser_id() == sellerId)
                .filter(p-> p instanceof PromoPost)
                .toList();
    }
}