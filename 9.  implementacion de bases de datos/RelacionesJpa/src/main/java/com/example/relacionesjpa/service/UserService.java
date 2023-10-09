package com.example.relacionesjpa.service;


import com.example.relacionesjpa.dto.OneToOne.RespUserDto;
import com.example.relacionesjpa.dto.OneToOne.UserDto;
import com.example.relacionesjpa.entity.OneToOne.Address;
import com.example.relacionesjpa.entity.OneToOne.User;
import com.example.relacionesjpa.repository.AddressRepository;
import com.example.relacionesjpa.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    UserRepository userRepository;
    AddressRepository addressRepository;
    ModelMapper mapper = new ModelMapper();

    public UserService(UserRepository userRepository, AddressRepository addressRepository){
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<UserDto> buscarTodos() {
        List<User> allUser = userRepository.findAll();
        List<UserDto> allUserDto = allUser.stream().map(user -> mapper.map(user, UserDto.class)).collect(Collectors.toList());
        return allUserDto;
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
        User userToDelete = userRepository.findById(id).orElse(null);
        RespUserDto response = new RespUserDto();
        if (userToDelete!= null) {
            userRepository.deleteById(id);
            response = new RespUserDto(mapper.map(userToDelete,UserDto.class),"User deleted succesfully");
        }
        else response.setMessage("User not found");
        return response;
    }

    @Override
    public UserDto obtenerPorId(Long id) {
        User userToDelete = userRepository.findById(id).orElse(null);
        if (userToDelete!= null) {
            return mapper.map(userToDelete,UserDto.class);
        }
        return null;
    }
}
