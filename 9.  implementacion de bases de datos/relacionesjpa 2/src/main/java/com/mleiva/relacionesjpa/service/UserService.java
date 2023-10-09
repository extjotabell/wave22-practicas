package com.mleiva.relacionesjpa.service;


import com.mleiva.relacionesjpa.dto.OneToOne.RespUserDto;
import com.mleiva.relacionesjpa.dto.OneToOne.UserDto;
import com.mleiva.relacionesjpa.entity.OneToOne.Address;
import com.mleiva.relacionesjpa.entity.OneToOne.User;
import com.mleiva.relacionesjpa.exception.NotFoundException;
import com.mleiva.relacionesjpa.repository.AddressRepository;
import com.mleiva.relacionesjpa.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService{

    UserRepository userRepository;
    AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository){
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    ModelMapper mapper = new ModelMapper();
    @Override
    public List<UserDto> buscarTodos() {
        return userRepository.findAll().stream()
                .map(user -> mapper.map(user, UserDto.class))
                .toList();
    }

    @Override
    public RespUserDto guardarUser(UserDto userDto) {
        User user = mapper.map(userDto,User.class);
        Address address= new Address(null,userDto.getAddress().getCity(),user);
        user.setAddress(address);
        userRepository.save(user);
        return new RespUserDto(userDto,"guardado con éxito.");
    }

    @Override
    public RespUserDto borrarUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            throw new NotFoundException();
        }
        userRepository.deleteById(id);
        RespUserDto resp = new RespUserDto();
        resp.setMessage("borrado exitoso");
        return resp;
    }

    @Override
    public UserDto obtenerPorId(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            throw new NotFoundException();
        }
        return mapper.map(user,UserDto.class);
    }
}
