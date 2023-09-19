package com.w22_g03.be_java_hisp_w22_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostByVendorDTO {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("posts")
    private List<PromoPostDTO> posts;

    public static PostByVendorDTO buildPostByVendorDTO(User user, List<PromoPostDTO> postsDTO){
        return PostByVendorDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUsername())
                .posts(postsDTO)
                .build();
    }
}
