package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.PromoPostDto;
import com.meli.be_java_hisp_w22_g01.dto.response.CountPromoPostDTO;
import com.meli.be_java_hisp_w22_g01.entity.*;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
import com.meli.be_java_hisp_w22_g01.repository.IPostRepository;
import com.meli.be_java_hisp_w22_g01.repository.IProductRepository;
import com.meli.be_java_hisp_w22_g01.repository.ISellerRepository;
import com.meli.be_java_hisp_w22_g01.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImp implements IPostService{

    @Autowired
    IPostRepository postRepository;

    @Autowired
    IProductRepository productRepository;

    @Autowired
    ISellerRepository sellerRepository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    ObjectMapper mapper;
    @Override
    public void createPost(PostDto postDto) {
        Post post = mapper.convertValue(postDto, Post.class);
        Seller seller = sellerRepository.findById(post.getUser_id());
        if(seller == null){
            throw new NotFoundException("No existe el vendedor con id: "+ post.getUser_id());
        }
        Product product = productRepository.getById(post.getProduct().getProduct_id());
        if(product == null) {
            productRepository.save(post.getProduct());
        }
        postRepository.addPost(post);
    }
    // US 0010
    @Override
    public void createPromoPost(PromoPostDto promoPostDto){
        PromoPost promoPost = mapper.convertValue(promoPostDto, PromoPost.class);
        int productId = promoPost.getProduct().getProduct_id();

        // Si el producto ya esta en oferta se lanza una excepción
        if (postRepository.checkProductInPromo(productId)){
            throw new NotFoundException("El producto productId: " + productId + " ya se encuentra en oferta");
        }

        Seller seller = sellerRepository.findById(promoPost.getUser_id());
        if(seller == null){
            throw new NotFoundException("No existe el vendedor con id: "+ promoPost.getUser_id());
        }
        Product product = productRepository.getById(promoPost.getProduct().getProduct_id());
        if(product == null) {
            productRepository.save(promoPost.getProduct());
        }
        postRepository.addPost(promoPost);
    }

    // US 0011
    @Override
    public CountPromoPostDTO countPromoPost(int user_id) {
        List<Post> posts = postRepository.getAllPosts();
        List<Post> postPromo = posts.stream()
                .filter(p -> p.getUser_id() == user_id)
                .filter(p -> p instanceof PromoPost)
                .toList();

        int countPromos = postPromo.size();
        User seller = sellerRepository.findById(user_id);
        String sellerName = seller.getUser_name();

        CountPromoPostDTO countPromoPostDTO = new CountPromoPostDTO();
        countPromoPostDTO.setUser_id(user_id);
        countPromoPostDTO.setUser_name(sellerName);
        countPromoPostDTO.setPromo_products_count(countPromos);

        return countPromoPostDTO;
    }
}
