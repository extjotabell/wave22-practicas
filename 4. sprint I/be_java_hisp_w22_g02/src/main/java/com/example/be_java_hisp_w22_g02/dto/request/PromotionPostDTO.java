package com.example.be_java_hisp_w22_g02.dto.request;

import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.entity.Promotion;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromotionPostDTO extends PostDTO{

    private boolean hasPromo;
    private double discount;

    public PromotionPostDTO(int userId, LocalDate date, ProductDto product, int category, Double price, Boolean hasPromo, Double discount){
        super(userId,date,product, category,price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
