package com.example.be_java_hisp_w22_g05.utils;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.ProductDto;
import com.example.be_java_hisp_w22_g05.dto.UserDto;
import com.example.be_java_hisp_w22_g05.entity.Post;
import com.example.be_java_hisp_w22_g05.entity.Product;
import com.example.be_java_hisp_w22_g05.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostGenerator {

    private static ObjectWriter mapper;

    public PostGenerator(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

         this.mapper = objectMapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    public static String postDtoParserString(PostDto postDto) throws Exception {
        return mapper.writeValueAsString(postDto);
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

    public static List<PostDto> getPostDtoListDesc(){
        List<PostDto> expected = new ArrayList<>();

        expected.add(new PostDto(1,2, LocalDate.now().minusDays(3), new ProductDto(2,"Silla Gamer","Gamer","Racer", "Red and Black", "Special Edition" ), 100, 1500.0, null, null));
        expected.add(new PostDto(2,2,LocalDate.now().minusDays(4), new ProductDto(1,"Silla Gamer II","Gamer","Racer", "Blue and Black", "Special Edition" ), 101, 1700.0, null, null));

        return expected;
    }

    public static List<PostDto> getPostDtoListAsc(){
        List<PostDto> expected = new ArrayList<>();

        expected.add(new PostDto(2,2,LocalDate.now().minusDays(4), new ProductDto(1,"Silla Gamer II","Gamer","Racer", "Blue and Black", "Special Edition" ), 101, 1700.0, null, null));
        expected.add(new PostDto(1,2, LocalDate.now().minusDays(3), new ProductDto(2,"Silla Gamer","Gamer","Racer", "Red and Black", "Special Edition" ), 100, 1500.0, null, null));

        return expected;
    }
    public static List<Post> getPostList(User user){
        List<Post> postList = new ArrayList<>();

        Post post1 = new Post(1, LocalDate.now().minusDays(3),100,user,new Product(2,"Silla Gamer","Gamer","Racer", "Red and Black", "Special Edition" ),1500.0,null,null);
        Post post2 = new Post(2, LocalDate.now().minusDays(4),101,user,new Product(1,"Silla Gamer II","Gamer","Racer", "Blue and Black", "Special Edition" ),1700.0,null,null);

        postList.add(post1);
        postList.add(post2);
        return postList;
    }

    public static List<Post> getPostListAroundLimitDate(User userPost){
        List<Post> postList = new ArrayList<>();

        Product product1 = new Product(1, "arroz", "comida", "Gallo", "blanco", "");
        Product product2 = new Product(2, "mouse", "IT", "Logitech", "Negro", "");

        Post post1 = new Post(1, LocalDate.now().minusDays(13), 1, userPost, product1, 200.0, null, null);
        Post post2 = new Post(2, LocalDate.now().minusDays(14), 2, userPost, product2, 1200.0, null, null);
        Post post3 = new Post(3, LocalDate.now().minusDays(15), 3, userPost, product2, 2500.0, null, null);

        postList.add(post1);
        postList.add(post2);
        postList.add(post3);

        return postList;
    }

    public static List<PostDto> getPostDTOList(User user){
        ProductDto productDto1 = new ProductDto(1, "arroz", "comida", "Gallo", "blanco", "");
        ProductDto productDto2 = new ProductDto(2, "mouse", "IT", "Logitech", "Negro", "");
        List<PostDto> postDtoList = new ArrayList<>();

        postDtoList.add(new PostDto(1, user.getId(), LocalDate.now().minusDays(13), productDto1, 1,  200.0, null, null));
        postDtoList.add(new PostDto(2, user.getId(), LocalDate.now().minusDays(14), productDto2, 2,   1200.0, null, null));

        return postDtoList;
    }
}
