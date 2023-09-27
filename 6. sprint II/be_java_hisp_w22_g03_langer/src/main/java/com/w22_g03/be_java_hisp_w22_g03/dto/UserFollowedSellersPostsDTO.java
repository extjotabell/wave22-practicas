package com.w22_g03.be_java_hisp_w22_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserFollowedSellersPostsDTO {

    @JsonProperty(value = "user_id", index = 0)
    private long userId;

    private List<PostDTO> posts;
}
