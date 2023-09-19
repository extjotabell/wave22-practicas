package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.response.CountFollowedDto;
import com.meli.be_java_hisp_w22_g01.dto.response.PromoPostListDto;
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
import java.util.List;


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
        int id = postRepository.getAllPosts().size();
        post.setPost_id(id);
        List<Post> newPost = seller.getPosts();
        newPost.add(post);

        seller.setPosts(newPost);
        sellerRepository.updateUser(seller.getUser_id(), seller);
    }

    @Override
    public CountFollowedDto countPromo(int userId) {
        /* También se puede realizar de esta forma:
         Seller seller = sellerRepository.findById(userId);
        if(seller == null) {
            throw new NotFoundException("No se encontró el usuario con id: " + userId);
        }
        int count = (int) seller.getPosts().stream().filter(Post::isHas_promo).count();
        return new CountFollowedDto(userId,sellerRepository.findById(userId).getUser_name(),count);
         */

        List<Post> list =  getPromoPostListDto(userId);
        int count = list.size();
        return new CountFollowedDto(userId,sellerRepository.findById(userId).getUser_name(),count);
    }

    @Override
    public PromoPostListDto listPromo(int userId) {
        /* También se puede realizar de esta forma:
        Seller seller = sellerRepository.findById(userId);
        if(seller == null) {
            throw new NotFoundException("No se encontró el usuario con id: " + userId);
        }
        List<Post> list = seller.getPosts().stream().filter(Post::isHas_promo).toList();
        List<PostDto> listDto = list.stream().map(p -> mapper.convertValue(p,PostDto.class)).toList();
        return new PromoPostListDto(userId,seller.getUser_name(),listDto);*/

        List <Post> list = getPromoPostListDto(userId);
        List<PostDto> listDto = list.stream().map(p -> mapper.convertValue(p,PostDto.class)).toList();
        return new PromoPostListDto(userId,sellerRepository.findById(userId).getUser_name(),listDto);
    }

    private List<Post>  getPromoPostListDto(int userId) {
        List<Post> list = postRepository.findByIdSeller(userId);
        list = list.stream().filter(Post::isHas_promo).toList();
        if (list.isEmpty()){
            throw new NotFoundException("No se encontró el usuario con id: " + userId);
        }
        return list;
    }
}
