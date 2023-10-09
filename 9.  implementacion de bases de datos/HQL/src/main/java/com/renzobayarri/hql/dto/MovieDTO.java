package com.renzobayarri.hql.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class MovieDTO {

    private int id;

    private String title;

    private BigDecimal rating;

    private int awards;

    private LocalDateTime releaseDate;

    private Integer length;

    private GenreDTO genre;
}
