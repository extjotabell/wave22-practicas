package com.example.be_java_hisp_w22_g02.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @JsonAlias({"post_id"})
    protected int postId;
    @JsonAlias({"user_id"})
    protected int userId;
    protected LocalDate date;
    protected Product product;
    protected int category;
    protected double price;
}

