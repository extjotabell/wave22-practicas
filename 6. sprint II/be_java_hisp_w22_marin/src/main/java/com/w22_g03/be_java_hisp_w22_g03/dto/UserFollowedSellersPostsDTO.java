package com.w22_g03.be_java_hisp_w22_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
public class UserFollowedSellersPostsDTO {

    @JsonProperty(value = "user_id", index = 0)
    private long userId;

    private List<PostDTO> posts;
}
