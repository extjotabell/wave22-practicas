package com.example.be_java_hisp_w22_g02.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int user_id;
    private String user_name;
    private List<User> followers = new ArrayList<>();
    private List<User> followed = new ArrayList<>();
}
