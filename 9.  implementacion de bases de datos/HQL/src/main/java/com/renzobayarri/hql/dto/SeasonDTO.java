package com.renzobayarri.hql.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SeasonDTO {

    private int id;

    private String title;

    private int number;

    private LocalDateTime releaseDate;

    private LocalDateTime endDate;

    private SerieDTO serie;
}
