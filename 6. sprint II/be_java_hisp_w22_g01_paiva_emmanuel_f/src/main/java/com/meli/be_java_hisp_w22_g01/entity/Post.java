package com.meli.be_java_hisp_w22_g01.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private int user_id;
    private int post_id;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private int category;
    private double price;
    
    
}
