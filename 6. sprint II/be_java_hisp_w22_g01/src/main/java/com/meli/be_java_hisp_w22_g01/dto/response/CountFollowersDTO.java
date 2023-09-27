package com.meli.be_java_hisp_w22_g01.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class CountFollowersDTO {
    private int user_id;
    private String user_name;
    private int followers;
}
