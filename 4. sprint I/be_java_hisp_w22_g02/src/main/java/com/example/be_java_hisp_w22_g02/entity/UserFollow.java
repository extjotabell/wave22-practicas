package com.example.be_java_hisp_w22_g02.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserFollow {

    @JsonAlias({"user_id"})
    private int userId;

    @JsonAlias({"user_name"})
    private String userName;
}
