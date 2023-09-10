package com.example.Blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BlogEntryDTO {

        private int id;
        private String title;
        private String author;
        private String date;

}
