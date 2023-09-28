package com.meli.be_java_hisp_w22_g01.dto.response;

import com.meli.be_java_hisp_w22_g01.dto.PostDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserFollowedPostListDTO {
    private int user_id;
    private List<PostDTO> posts;
}
