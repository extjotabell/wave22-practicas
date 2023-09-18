package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.PromoDTO;
import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.entity.Product;
import com.meli.be_java_hisp_w22_g01.entity.PromoPost;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.exceptions.NotFoundException;
import com.meli.be_java_hisp_w22_g01.repository.IPostRepository;
import com.meli.be_java_hisp_w22_g01.repository.IProductRepository;
import com.meli.be_java_hisp_w22_g01.repository.ISellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        createPost(post);
    }

    @Override
    public void createPost(PromoDTO promoDTO) {
        PromoPost post = mapper.convertValue(promoDTO, PromoPost.class);
        createPost(post);
    }

    private void createPost(Post post) {
        Seller seller = sellerRepository.findById(post.getUser_id());
        if(seller == null){
            throw new NotFoundException("No existe el vendedor con id: "+ post.getUser_id());
        }
        Product product = productRepository.getById(post.getProduct().getProduct_id());
        if(product == null) {
            productRepository.save(post.getProduct());
        }
        seller.addPost(post);
        postRepository.addPost(post);
    }


}
