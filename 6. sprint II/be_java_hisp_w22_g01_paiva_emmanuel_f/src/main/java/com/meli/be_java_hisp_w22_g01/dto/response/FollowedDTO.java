package com.meli.be_java_hisp_w22_g01.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FollowedDTO {
    private int user_id;
    private String user_name;
    private List<UserMiniDTO> followed;
}