package com.example.be_java_hisp_w22_g02.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

//@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promotion extends Post {

    private boolean hasPromo;
    private double discount;

    public Promotion(int postId, int userId, LocalDate date, Product product, int category, double price){
        super(postId, userId, date, product,category,price);
    }


}
