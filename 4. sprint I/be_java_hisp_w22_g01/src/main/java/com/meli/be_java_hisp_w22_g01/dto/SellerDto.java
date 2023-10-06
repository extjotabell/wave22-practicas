package com.meli.be_java_hisp_w22_g01.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDto extends UserDto{
    List<PostDto> posts;
    List<UserDto> followers;
}