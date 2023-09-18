package com.w22_g03.be_java_hisp_w22_g03_bayarri.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromoPostByUserDTO extends UserFollowedSellersPostsDTO{

    @JsonProperty(value = "user_name", index = 1)
    private String username;

}
