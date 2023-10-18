package com.mercadolibre.bootcamp_demo_java_app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CurrencyConversionDTO {

  @JsonProperty("currency_base")
  private String currencyBase;

  @JsonProperty("currency_quote")
  private String currencyQuote;

  @JsonProperty("ratio")
  private Double ratio;

  @JsonProperty("inv_rate")
  private Double inverseRatio;

}
