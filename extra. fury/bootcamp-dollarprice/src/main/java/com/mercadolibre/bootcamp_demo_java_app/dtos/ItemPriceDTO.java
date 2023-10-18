package com.mercadolibre.bootcamp_demo_java_app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPriceDTO {

  private String itemId;

  private String title;

  private Double localPrice;

  private Double dollarPrice;

  private Double conversionRateUsed;

}
