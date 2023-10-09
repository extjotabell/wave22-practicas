package com.example.relacionesjpa.util;

import com.example.relacionesjpa.dto.OneToMany.CartDto;
import com.example.relacionesjpa.dto.OneToOne.AdressDto;
import com.example.relacionesjpa.dto.OneToOne.UserDto;
import com.example.relacionesjpa.entity.OneToMany.Cart;
import com.example.relacionesjpa.entity.OneToOne.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapeador {

    public static UserDto entityUserToDto (User user){

        AdressDto adressDto = new AdressDto();
        adressDto.setCity(user.getAddress().getCity());
        return new UserDto(user.getId(), adressDto);
    }

    public static CartDto entityToDto (Cart cart){

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.convertValue(cart, CartDto.class);
    }

    public static Cart dtoToEntity (CartDto cart){

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.convertValue(cart, Cart.class);
    }


}
