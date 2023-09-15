package com.meli.be_java_hisp_w22_g01.dto.response;

import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowedPostListDTO {
    private int user_id;
    private List<PostDto> posts;
}
