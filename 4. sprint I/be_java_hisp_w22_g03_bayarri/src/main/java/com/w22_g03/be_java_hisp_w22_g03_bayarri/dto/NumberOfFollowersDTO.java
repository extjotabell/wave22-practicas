package com.w22_g03.be_java_hisp_w22_g03_bayarri.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NumberOfFollowersDTO {

    @JsonProperty(value = "user_id", index = 0)
    private int userId;

    @JsonProperty(value = "user_name", index = 1)
    private String username;

    @JsonProperty(value = "followers_count", index = 2)
    private int followersCount;
}
