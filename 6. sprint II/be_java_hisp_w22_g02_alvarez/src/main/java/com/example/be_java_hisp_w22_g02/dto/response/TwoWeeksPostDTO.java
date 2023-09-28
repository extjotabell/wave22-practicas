package com.example.be_java_hisp_w22_g02.dto.response;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TwoWeeksPostDTO {
    private int userId;
    private List<PostDTO> posts;
}
