package com.w22_g03.be_java_hisp_w22_g03_bayarri.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDTO extends PostDTO {

    @JsonProperty("has_promo")
    @NotNull
    private Boolean hasPromo;

    @NotNull
    private Double discount;
}
