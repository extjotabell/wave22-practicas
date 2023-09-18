package com.w22_g03.be_java_hisp_w22_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetPostPromoDTO {
    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("followers_count")
    private long countPost;
}
