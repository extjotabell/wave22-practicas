package com.example.be_java_hisp_w22_g05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PromoPostListDto {
    @JsonProperty("user_id")
    private int id;

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("posts")
    List<PostDto> postDtoList;
}
