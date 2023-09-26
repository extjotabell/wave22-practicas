package com.w22_g03.be_java_hisp_w22_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NumberOfFollowersDTO {
    @JsonProperty("user_id")
    int userId;

    @JsonProperty("user_name")
    String username;

    @JsonProperty("followers_count")
    int followersCount;
}