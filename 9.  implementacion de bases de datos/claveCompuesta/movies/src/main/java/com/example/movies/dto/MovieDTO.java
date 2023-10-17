package com.example.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private Date createdAt;
    private Date updatedAt;
    private String title;
    private double rating;
    private int awards;
    private Date releaseDate;
    private int length;
    private int genreId;
}
