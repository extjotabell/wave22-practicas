package com.w22_g03.be_java_hisp_w22_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.w22_g03.be_java_hisp_w22_g03.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowedDTO {

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("followed")
    private List<UserDTO> followed;

    public static FollowedDTO buildFollowedDTO(UserDTO user, List<UserDTO> followed){
        return FollowedDTO.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .followed(followed)
                .build();
    }
}
