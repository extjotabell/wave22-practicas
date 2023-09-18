package com.meli.be_java_hisp_w22_g01.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMiniDTO {
    private int user_id;
    private String user_name;
}
