package com.meli.be_java_hisp_w22_g01.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserFollowersListDTO {
    private int user_id;
    private String user_name;
    private List<UserMiniDTO> followers;
}
