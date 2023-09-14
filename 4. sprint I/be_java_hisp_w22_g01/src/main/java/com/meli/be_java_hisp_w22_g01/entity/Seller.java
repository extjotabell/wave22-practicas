package com.meli.be_java_hisp_w22_g01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller extends User{
    List<Post> posts;
    List<User> followers;
}
