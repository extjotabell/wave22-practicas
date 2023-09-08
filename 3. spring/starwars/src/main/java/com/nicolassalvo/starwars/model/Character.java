package com.nicolassalvo.starwars.model;

import lombok.Getter;

@Getter
public class Character {
    private String name;
    private int height;
    private int mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String BirthYear;
    private String gender;
    private String homeworld;
    private String species;

    public void setMass(Object mass) {
        if (mass instanceof Integer) {
            this.mass = (int) mass;
        }
    }
    public void setHeight(Object mass) {
        if (mass instanceof Integer) {
            this.mass = (int) mass;
        }
    }
}