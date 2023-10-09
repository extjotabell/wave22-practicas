package com.renzobayarri.hql.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class EpisodeDTO {

    private int id;

    private String title;

    private int number;

    private LocalDateTime releaseDate;

    private BigDecimal rating;

    private SeasonDTO season;
}
