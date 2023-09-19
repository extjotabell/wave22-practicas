package com.example.be_java_hisp_w22_g02.dto.response;

import com.example.be_java_hisp_w22_g02.dto.response.UserFollowDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDTO {
    @JsonAlias({"user_id"})
    private int userId;
    @JsonAlias({"user_name"})
    private String userName;
    private List<UserFollowDTO> followers = new ArrayList<>();
    private List<UserFollowDTO> followed = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
}