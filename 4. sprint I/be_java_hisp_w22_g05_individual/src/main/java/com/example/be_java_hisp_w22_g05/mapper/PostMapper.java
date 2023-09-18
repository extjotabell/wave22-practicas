package com.example.be_java_hisp_w22_g05.mapper;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.ProductDto;
import com.example.be_java_hisp_w22_g05.entity.Post;
import com.example.be_java_hisp_w22_g05.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public PostDto toPostDTO(Post post){
        return PostDto.builder()
                .id(post.getId())
                .userId(post.getUser().getId())
                .date(post.getDate().toString())
                .category(post.getCategory())
                .product(this.toProductDTO(post.getProduct()))
                .price(post.getPrice())
                .discount(post.getDiscount())
                .hasPromo(post.getHasPromo())
                .build();
    }

    private ProductDto toProductDTO(Product product){
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
