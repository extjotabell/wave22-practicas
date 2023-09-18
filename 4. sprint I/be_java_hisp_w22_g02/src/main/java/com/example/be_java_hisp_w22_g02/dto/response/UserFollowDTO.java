package com.example.be_java_hisp_w22_g02.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public class UserFollowDTO {
    private int userId;
    private String userName;
    private List<UserFollowDTO> followers = new ArrayList<>();
    private List<UserFollowerDTO> followed = new ArrayList<>();
}
