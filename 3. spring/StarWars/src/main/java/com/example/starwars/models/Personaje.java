package com.example.starwars.models;

import lombok.*;



@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Personaje {

   private String name;
   private Integer height;
   private Integer mass;
   private String hairColor;
   private String skinColor;
   private String eyeColor;
   private String birthYear;
   private String gender;
   private String homeworld;
   private String sprecies;



}
