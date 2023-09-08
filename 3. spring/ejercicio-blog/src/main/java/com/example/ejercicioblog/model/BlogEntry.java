package com.example.ejercicioblog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogEntry {

    private int id;
    private String title;
    private String author;
    private Date date;
}
