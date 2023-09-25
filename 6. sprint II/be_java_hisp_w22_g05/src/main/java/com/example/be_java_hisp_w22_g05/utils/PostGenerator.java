package com.example.be_java_hisp_w22_g05.utils;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.ProductDto;
import com.example.be_java_hisp_w22_g05.entity.Post;
import com.example.be_java_hisp_w22_g05.entity.Product;
import com.example.be_java_hisp_w22_g05.entity.User;

import java.time.LocalDate;
import java.util.List;

public class PostGenerator {

    private PostGenerator(){

    }

    public static List<Post> postGenerator(User user){
        Product producto1 = new Product(1,"reloj","ropa","alguna","negro","");
        Product producto2 = new Product(2,"zapatos","ropa","alguna","negro","");

        Post post1 = new Post(1, LocalDate.now().minusDays(4),1,user,producto1,null,null,null);
        Post post2 = new Post(2, LocalDate.now().minusDays(2),1,user,producto2,null,null,null);

        return List.of(post1, post2);
    }

    public static List<PostDto> postDtoGenerator(){
        ProductDto productDto = new ProductDto(1,"reloj","ropa","alguna","negro","");
        ProductDto productDto2 = new ProductDto(2,"zapatos","ropa","alguna","negro","");

        PostDto postDto1 = new PostDto(1,2, LocalDate.now().minusDays(4),productDto,1,null,null,null);
        PostDto postDto2 = new PostDto(2,2, LocalDate.now().minusDays(2),productDto2,1,null,null,null);

        return List.of(postDto1, postDto2);
    }
}
