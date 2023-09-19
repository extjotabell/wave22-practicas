package com.example.be_java_hisp_w22_g02.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoDTO extends PostDTO {

    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;
}
