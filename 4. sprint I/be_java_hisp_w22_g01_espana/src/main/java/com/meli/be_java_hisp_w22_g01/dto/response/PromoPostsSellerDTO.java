package com.meli.be_java_hisp_w22_g01.dto.response;

import com.meli.be_java_hisp_w22_g01.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostsSellerDTO {
    private int user_id;
    private String user_name;
    private List<Post> posts;
}
