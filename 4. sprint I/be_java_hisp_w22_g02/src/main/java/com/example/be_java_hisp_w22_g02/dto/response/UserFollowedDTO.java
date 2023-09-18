package com.example.be_java_hisp_w22_g02.dto.response;

import com.example.be_java_hisp_w22_g02.entity.UserFollow;
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
public class UserFollowedDTO {
    private int userId;
    private String userName;
    private List<UserFollowDTO> followed = new ArrayList<>();
}
