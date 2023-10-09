package com.mleiva.relacionesjpa.service;

import com.mleiva.relacionesjpa.dto.OneToOne.RespUserDto;
import com.mleiva.relacionesjpa.dto.OneToOne.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> buscarTodos();
    RespUserDto guardarUser(UserDto user);
    RespUserDto borrarUser(Long id);
    UserDto obtenerPorId(Long id);
}
