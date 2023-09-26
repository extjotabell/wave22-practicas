package com.example.be_java_hisp_w22_g05.utils;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.ProductDto;
import com.example.be_java_hisp_w22_g05.entity.Post;
import com.example.be_java_hisp_w22_g05.entity.Product;
import com.example.be_java_hisp_w22_g05.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Datos {


    public static User getUser(){
        List<User> followed = new ArrayList<>();
        User user1 = new User();
        user1.setId(2);
        followed.add(user1);
        User user = new User(1, "Roberto",null, followed);
        return user;
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
}
