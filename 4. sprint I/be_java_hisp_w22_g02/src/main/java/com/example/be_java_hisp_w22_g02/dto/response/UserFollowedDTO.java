package com.example.be_java_hisp_w22_g02.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowedDTO {
    private Long userId;
    private String userName;
    private List<UserDto> followed;
}
