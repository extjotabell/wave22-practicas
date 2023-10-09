package com.example.relacionesjpa.service;


import com.example.relacionesjpa.dto.OneToOne.RespUserDto;
import com.example.relacionesjpa.dto.OneToOne.UserDto;
import com.example.relacionesjpa.entity.OneToOne.Address;
import com.example.relacionesjpa.entity.OneToOne.User;
import com.example.relacionesjpa.repository.AddressRepository;
import com.example.relacionesjpa.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    UserRepository userRepository;
    AddressRepository addressRepository;

    ModelMapper mapper;

    public UserService(UserRepository userRepository, AddressRepository addressRepository){
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<UserDto> buscarTodos() {
        List<User> usuarios = userRepository.findAll();
        return usuarios.stream().map(u -> mapper.map(u, UserDto.class)).collect(Collectors.toList());
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
        userRepository.deleteById(id);
        return new RespUserDto(null,"Borrado exitoso");
    }

    @Override
    public UserDto obtenerPorId(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return mapper.map(user, UserDto.class);
    }
}
