package com.renzobayarri.hql.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ActorDTO {

    private int id;

    private String firstName;

    private String lastName;

    private BigDecimal rating;

    private MovieDTO favoriteMovie;
}
