package com.meli.be_java_hisp_w22_g01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller extends User{
    List<Post> posts;
    List<User> followers;

    public void addPost(Post post) {
        posts.add(post);
    }
}
