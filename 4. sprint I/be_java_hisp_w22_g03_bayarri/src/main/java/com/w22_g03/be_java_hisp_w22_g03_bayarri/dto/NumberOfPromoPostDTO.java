package com.w22_g03.be_java_hisp_w22_g03_bayarri.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NumberOfPromoPostDTO {

    @JsonProperty(value = "user_id", index = 0)
    private long userId;

    @JsonProperty(value = "user_name", index = 1)
    private String username;

    @JsonProperty(value = "promo_products_count", index = 2)
    private long quantity;
}
