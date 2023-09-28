package com.w22_g03.be_java_hisp_w22_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class FollowerDTO {

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("followers")
    private List<UserDTO> followers;

    public static FollowerDTO buildFollowerDTO(UserDTO user, List<UserDTO> followers){
        return FollowerDTO.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .followers(followers)
                .build();
    }

}