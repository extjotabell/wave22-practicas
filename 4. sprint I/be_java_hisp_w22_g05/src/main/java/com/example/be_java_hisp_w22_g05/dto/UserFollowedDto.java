package com.example.be_java_hisp_w22_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserFollowedDto {
    @JsonProperty("user_id")
    private int id;
    @JsonProperty("user_name")
    private String userName;
    private List<UserDto> followed;
}
