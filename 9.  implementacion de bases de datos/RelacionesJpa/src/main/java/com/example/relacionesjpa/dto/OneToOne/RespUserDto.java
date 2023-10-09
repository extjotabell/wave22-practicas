package com.example.relacionesjpa.dto.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RespUserDto {
    private UserDto userDto;
    private String message;
}
