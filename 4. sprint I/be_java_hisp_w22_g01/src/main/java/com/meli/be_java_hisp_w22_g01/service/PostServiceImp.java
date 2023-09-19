package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.response.SellerPromoDTO;
import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.entity.Product;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
import com.meli.be_java_hisp_w22_g01.repository.IPostRepository;
import com.meli.be_java_hisp_w22_g01.repository.IProductRepository;
import com.meli.be_java_hisp_w22_g01.repository.ISellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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
            throw new NotFoundException("No existe el vendedor con id: "+ post.getUser_id());
        }
        Product product = productRepository.getById(post.getProduct().getProduct_id());
        if(product == null) {
            productRepository.save(post.getProduct());
        }

        postRepository.addPost(post);
    }

    @Override
    public List<Post> getAllpost(){
        return postRepository.getAllPosts();
    }

    @Override
    public SellerPromoDTO countPromosByUser(int user_id) {

        List<Post> posts = postRepository.getAllPosts();
        SellerPromoDTO sellerPromo = new SellerPromoDTO();

        Seller seller = sellerRepository.findById(user_id);
        if(seller == null){
            throw new NotFoundException("No existe el vendedor con id: "+ user_id);
        }

        sellerPromo.setUser_id(seller.getUser_id());
        sellerPromo.setUser_name(seller.getUser_name());

        for(Post post : posts){
            if(post.getUser_id() == user_id && post.getPromo() != null){
                sellerPromo.setPromo_products_count(sellerPromo.getPromo_products_count() + 1);
            }
        }

        return sellerPromo;
    }

}
