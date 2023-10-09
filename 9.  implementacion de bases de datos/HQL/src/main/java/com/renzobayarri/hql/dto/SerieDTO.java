package com.renzobayarri.hql.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SerieDTO {

    private int id;

    private String title;

    private LocalDateTime releaseDate;

    private LocalDateTime endDate;

    private GenreDTO genre;
}
