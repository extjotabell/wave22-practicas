package com.example.be_java_hisp_w22_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"user_id", "user_name", "post_id","date","product","category","price","has_promo","discount"})
public class PostPromoDto extends PostDto{
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Double discount;

    public PostPromoDto(int id, int userId, String date, ProductDto product, int category, Double price, Boolean hasPromo, Double discount) {
        super(id, userId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
