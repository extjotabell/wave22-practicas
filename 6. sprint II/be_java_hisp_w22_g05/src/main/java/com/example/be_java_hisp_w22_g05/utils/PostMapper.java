package com.example.be_java_hisp_w22_g05.utils;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.ProductDto;
import com.example.be_java_hisp_w22_g05.entity.Post;
import com.example.be_java_hisp_w22_g05.entity.Product;
import org.springframework.stereotype.Component;

public class PostMapper {

    public static PostDto toPostDTO(Post post){
        return PostDto.builder()
                .id(post.getId())
                .userId(post.getUser().getId())
                .date(post.getDate())
                .category(post.getCategory())
                .product(toProductDTO(post.getProduct()))
                .price(post.getPrice())
                .build();
    }

    private static ProductDto toProductDTO(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .type(product.getType())
                .brand(product.getBrand())
                .color(product.getColor())
                .notes(product.getNotes())
                .build();
    }
}
