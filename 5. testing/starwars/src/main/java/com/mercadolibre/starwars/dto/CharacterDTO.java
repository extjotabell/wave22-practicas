package com.mercadolibre.starwars.dto;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Controller;


@Data
public class CharacterDTO {
  private String name;
  private String hair_color;
  private String skin_color;
  private String eye_color;
  private String birth_year;
  private String gender;
  private String homeworld;
  private String species;
  private Integer height;
  private Integer mass;

  public CharacterDTO(String name, String hair_color, String skin_color, String eye_color, String birth_year, String gender, String homeworld, String species, Integer height, Integer mass) {
    this.name = name;
    this.hair_color = hair_color;
    this.skin_color = skin_color;
    this.eye_color = eye_color;
    this.birth_year = birth_year;
    this.gender = gender;
    this.homeworld = homeworld;
    this.species = species;
    this.height = height;
    this.mass = mass;
  }

  public CharacterDTO() {
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setHair_color(String hair_color) {
    this.hair_color = hair_color;
  }

  public void setSkin_color(String skin_color) {
    this.skin_color = skin_color;
  }

  public void setEye_color(String eye_color) {
    this.eye_color = eye_color;
  }

  public void setBirth_year(String birth_year) {
    this.birth_year = birth_year;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setHomeworld(String homeworld) {
    this.homeworld = homeworld;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public void setMass(Integer mass) {
    this.mass = mass;
  }
}
