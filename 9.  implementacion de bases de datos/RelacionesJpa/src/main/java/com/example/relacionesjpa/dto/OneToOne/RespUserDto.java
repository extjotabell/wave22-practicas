package com.example.relacionesjpa.dto.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class RespUserDto {
    private UserDto userDto;
    private String message;
}
