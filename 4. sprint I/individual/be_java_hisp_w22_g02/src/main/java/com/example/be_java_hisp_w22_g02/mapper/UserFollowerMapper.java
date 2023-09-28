package com.example.be_java_hisp_w22_g02.mapper;

import com.example.be_java_hisp_w22_g02.dto.response.UserFollowerDTO;
import com.example.be_java_hisp_w22_g02.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserFollowerMapper {
    UserFollowerDTO toDto (User user);
    User toEntity(UserFollowerDTO userFollowerDTO);
}
