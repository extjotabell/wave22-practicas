package com.meli.be_java_hisp_w22_g01.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.meli.be_java_hisp_w22_g01.dto.PostDiscountDto;
import com.meli.be_java_hisp_w22_g01.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostsDiscountByUserDto {

    private int user_id;
    private String user_name;
    private List<PostDiscountDto> posts;
}
