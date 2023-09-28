package com.w22_g03.be_java_hisp_w22_g03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NumberOfFollowersDTO {
    int user_id;
    String user_name;
    int followers_count;
}
