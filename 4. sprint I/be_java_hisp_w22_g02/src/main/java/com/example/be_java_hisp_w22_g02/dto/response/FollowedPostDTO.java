package com.example.be_java_hisp_w22_g02.dto.response;

import com.example.be_java_hisp_w22_g02.entity.Post;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FollowedPost {
    private int followedUserId;
    private Post post;
}
