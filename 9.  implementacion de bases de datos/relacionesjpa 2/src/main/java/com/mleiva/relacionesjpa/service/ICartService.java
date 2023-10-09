package com.mleiva.relacionesjpa.service;

import com.mleiva.relacionesjpa.dto.OneToMany.CartDto;
import com.mleiva.relacionesjpa.dto.OneToMany.RespCartDto;

import java.util.List;

public interface ICartService {

    List<CartDto> buscarTodos();
    RespCartDto guardarCart(CartDto cart);
    RespCartDto borrarCart(Long id);
    CartDto obtenerPorId(Long id);
}
