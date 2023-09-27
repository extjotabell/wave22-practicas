package com.meli.be_java_hisp_w22_g01.entity;

import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seller extends User{


    List<Post> posts;
    List<User> followers;
}
