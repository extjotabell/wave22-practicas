package com.example.Blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogEntry {
    private int id;
    private String title;
    private String author;
    private String date;
}
