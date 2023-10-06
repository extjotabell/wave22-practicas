package com.example.relacionesjpa.service;


import com.example.relacionesjpa.dto.OneToOne.RespUserDto;
import com.example.relacionesjpa.dto.OneToOne.UserDto;
import com.example.relacionesjpa.entity.OneToOne.Address;
import com.example.relacionesjpa.entity.OneToOne.User;
import com.example.relacionesjpa.repository.AddressRepository;
import com.example.relacionesjpa.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    UserRepository userRepository;
    AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository){
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    // getAll, getbyId, delete, update, create
    @Override
    public List<UserDto> buscarTodos() {
        ModelMapper mapper = new ModelMapper();

        List<User> users = userRepository.findAll();
        return users.stream().map(user -> mapper.map(user , UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public RespUserDto guardarUser(UserDto userDto) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto,User.class);
        Address address= new Address(null,userDto.getAddress().getCity(),user);
        user.setAddress(address);
        userRepository.save(user);
        return new RespUserDto(userDto,"guardado con éxito.");
    }

    @Override
    public RespUserDto borrarUser(Long id) {
        ModelMapper mapper = new ModelMapper();
        Optional<User> user = userRepository.findById(id);

        UserDto userDto = mapper.map(user , UserDto.class);
        userRepository.deleteById(id);

        return new RespUserDto(userDto,"Eliminado correctamente");

    }

    @Override
    public UserDto obtenerPorId(Long id) {
        return null;
    }
}
