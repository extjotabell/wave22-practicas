package com.w22_g03.be_java_hisp_w22_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SellerPromotionsDTO {
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_name")
    private String username;

    private List<PostWithPromoDTO> posts;
}