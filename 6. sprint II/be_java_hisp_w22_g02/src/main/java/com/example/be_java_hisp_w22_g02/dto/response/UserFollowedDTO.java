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
@Builder
public class UserFollowedDTO {
    private int userId;
    private String userName;
    private List<UserFollowDTO> followed;

    public UserFollowedDTO(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
