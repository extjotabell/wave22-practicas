package com.example.be_java_hisp_w22_g02.mapper;

import com.example.be_java_hisp_w22_g02.dto.response.UserDTO;
import com.example.be_java_hisp_w22_g02.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto (User user);
    User toEntity(UserDTO userDTO);
}
