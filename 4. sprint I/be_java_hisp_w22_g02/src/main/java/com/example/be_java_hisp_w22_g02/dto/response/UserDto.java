package com.example.be_java_hisp_w22_g02.dto.response;

import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @JsonAlias({"user_id"})
    private int userId;

    @JsonAlias({"user_name"})
    private String userName;

    private List<UserFollowDTO> followers = new ArrayList<>();
    private List<UserFollowDTO> followed = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
}