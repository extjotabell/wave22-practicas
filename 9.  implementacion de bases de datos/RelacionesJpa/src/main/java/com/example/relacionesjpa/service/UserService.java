package com.example.relacionesjpa.service;


import com.example.relacionesjpa.dto.OneToOne.AddressDto;
import com.example.relacionesjpa.dto.OneToOne.RespUserDto;
import com.example.relacionesjpa.dto.OneToOne.UserDto;
import com.example.relacionesjpa.entity.OneToOne.Address;
import com.example.relacionesjpa.entity.OneToOne.User;
import com.example.relacionesjpa.repository.AddressRepository;
import com.example.relacionesjpa.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService implements IUserService {

    UserRepository userRepository;
    AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<UserDto> buscarTodos() {
        return userRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public RespUserDto guardarUser(UserDto userDto) {
        User user = toUser(userDto);
        userRepository.save(user);
        return new RespUserDto(userDto, "guardado con éxito.");
    }

    @Override
    public RespUserDto borrarUser(Long id) {
        UserDto userDto = obtenerPorId(id);
        userRepository.deleteById(id);
        return new RespUserDto(userDto, "El usuario fue eliminado con éxito");
    }

    @Override
    public UserDto obtenerPorId(Long id) {
        return toDTO(userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El usuario con id " + id + " no existe")));
    }

    private User toUser(UserDto userDto) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto, User.class);
        Address address = new Address(null, userDto.getAddress().getCity(), user);
        user.setAddress(address);
        return user;
    }

    private UserDto toDTO(User user) {
        ModelMapper mapper = new ModelMapper();
        UserDto userDto = mapper.map(user, UserDto.class);
        AddressDto address = new AddressDto(user.getAddress().getCity());
        userDto.setAddress(address);
        return userDto;
    }
}
