package com.example.relacionesjpa.service;


import com.example.relacionesjpa.dto.OneToOne.AdressDto;
import com.example.relacionesjpa.dto.OneToOne.RespUserDto;
import com.example.relacionesjpa.dto.OneToOne.UserDto;
import com.example.relacionesjpa.entity.OneToOne.Address;
import com.example.relacionesjpa.entity.OneToOne.User;
import com.example.relacionesjpa.repository.AddressRepository;
import com.example.relacionesjpa.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    UserRepository userRepository;
    AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository){
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<UserDto> buscarTodos() {
        List<User> users = userRepository.findAll();

        return users.stream().map(this::mapUserToUserDto).collect(Collectors.toList());
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
        User user = userRepository.findById(id).orElse(null);
        if (user != null)
        {
            UserDto userDto = mapUserToUserDto(user);
            userRepository.delete(user);
            return new RespUserDto(userDto, "Usuario con el id " + id + " eliminado exitosamente");
        }
        return new RespUserDto(null, "No se encontro el usuario con el id " + id);
    }

    @Override
    public UserDto obtenerPorId(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return mapUserToUserDto(user);
        }
        return null;
    }
    @Override
    public UserDto actualizarUsuario(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElse(null);
        if (user != null) {
            Address address= new Address(null,userDto.getAddress().getCity(),user);
            user.setAddress(address);
            userRepository.save(user);
            return this.mapUserToUserDto(user);
        }
        return null;

    }

    private UserDto mapUserToUserDto(User user){
        ModelMapper mapper = new ModelMapper();

        UserDto userDto = mapper.map(user, UserDto.class);
        userDto.setAddress(mapper.map(user.getAddress(), AdressDto.class));

        return userDto;
    }
}
