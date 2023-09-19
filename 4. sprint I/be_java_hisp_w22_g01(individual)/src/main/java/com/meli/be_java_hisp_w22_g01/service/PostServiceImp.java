package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.PostDiscountDto;
import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.ProductDto;
import com.meli.be_java_hisp_w22_g01.dto.response.CountDiscountPostDto;
import com.meli.be_java_hisp_w22_g01.dto.response.PostsDiscountByUserDto;
import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.entity.Product;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w22_g01.repository.IPostRepository;
import com.meli.be_java_hisp_w22_g01.repository.IProductRepository;
import com.meli.be_java_hisp_w22_g01.repository.ISellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements IPostService{

    private final IPostRepository postRepository;
    private final IProductRepository productRepository;
    private final ISellerRepository sellerRepository;
    private final ObjectMapper mapper;
    @Override
    public void createPost(PostDto postDto) {
        Post post = mapper.convertValue(postDto, Post.class);
        Seller seller = sellerRepository.findById(post.getUser_id());
        if(seller == null){
            throw new BadRequestException("No existe el vendedor con id: "+ post.getUser_id());
        }
        Product product = productRepository.getById(post.getProduct().getProduct_id());
        if(product == null) {
            productRepository.save(post.getProduct());
        }
        postRepository.addPost(post);
        int id = postRepository.getAllPosts().size();
        post.setPost_id(id);
        List<Post> newPost = seller.getPosts();
        newPost.add(post);

        seller.setPosts(newPost);
        sellerRepository.updateUser(seller.getUser_id(), seller);
    }

    @Override
    public void createPostWithDiscount(PostDiscountDto postDiscountDto) {
        Post post = mapper.convertValue(postDiscountDto, Post.class);
        Seller seller = sellerRepository.findById(post.getUser_id());
        if(seller == null){
            throw new BadRequestException("No existe el vendedor con id: " + post.getUser_id());
        }
        Product product = productRepository.getById(post.getProduct().getProduct_id());
        if(product == null) {
            productRepository.save(post.getProduct());
        }
        postRepository.addPostWithDiscount(post);

    }

    @Override
    public CountDiscountPostDto countDiscount(int userId) {

        CountDiscountPostDto response = new CountDiscountPostDto();
        response.setUser_id(userId);
        response.setUser_name(sellerRepository.findById(userId).getUser_name());
        response.setPromo_products_count(postRepository.productsWithDiscount(userId));

        return response;
    }

    @Override
    public PostsDiscountByUserDto getPostsWithDiscount(int userId) {
        List<Post> posts = postRepository.getProductsDiscount(userId);
        PostsDiscountByUserDto result = new PostsDiscountByUserDto();

        List<PostDiscountDto> postsDis = posts.stream()
                .map(post -> {
                    PostDiscountDto postDto = new PostDiscountDto();
                    postDto.setPost_id(post.getPost_id());
                    postDto.setProduct(mapper.convertValue(post.getProduct(), ProductDto.class));
                    postDto.setUser_id(userId);
                    postDto.setDate(post.getDate());
                    postDto.setPrice(post.getPrice());
                    postDto.setCategory(post.getCategory());
                    postDto.setDiscount(post.getDiscount());
                    postDto.setHas_promo(post.isHas_promo());
                    return postDto;
                })
                .toList();

        result.setUser_id(userId);
        result.setUser_name(sellerRepository.findById(userId).getUser_name());
        result.setPosts(postsDis);

        return result;

    }


}
