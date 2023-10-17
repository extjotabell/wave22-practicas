package com.mercadolibre.bootcamp_demo_java_app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemUsdDTO {

    @JsonProperty("item_id")
    private String id;

    @JsonProperty("price_usd")
    private Double priceUSD;
}
