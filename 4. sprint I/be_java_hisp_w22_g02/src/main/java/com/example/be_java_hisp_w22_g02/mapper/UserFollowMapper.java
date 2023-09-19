package com.example.be_java_hisp_w22_g02.mapper;

import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.entity.UserFollow;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserFollowMapper {
    UserFollow toDto (User user);
    User toEntity(UserFollow userDTO);
}
