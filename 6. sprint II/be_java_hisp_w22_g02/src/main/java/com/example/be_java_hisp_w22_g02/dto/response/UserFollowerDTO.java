package com.example.be_java_hisp_w22_g02.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFollowerDTO {
    private int userId;
    private String userName;
    private List<UserFollowDTO> followers;

    public UserFollowerDTO(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
