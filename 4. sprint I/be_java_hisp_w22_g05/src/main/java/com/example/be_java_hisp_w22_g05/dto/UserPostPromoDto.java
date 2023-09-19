package com.example.be_java_hisp_w22_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonPropertyOrder({"user_id", "user_name", "posts"})
public class UserPostPromoDto {

        @JsonProperty("user_id")
        private int userId;
        @JsonProperty("user_name")
        private String userName;
        private List<PostDto> posts;

}
