package com.renzobayarri.blog.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogDTO {

    private int id;

    private String title;

    private String authorName;

    private LocalDate publishDate;

}