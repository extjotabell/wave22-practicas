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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.relacionesjpa.util.Mapeador.entityUserToDto;

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
        List<User> usersEnt = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user: usersEnt) {
            userDtos.add(entityUserToDto(user));
        }
        return userDtos;
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
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new RuntimeException("Usuario no entrocntrado");
        }
        userRepository.deleteById(user.get().getId());
        return new RespUserDto(entityUserToDto(user.get()),"Usuario eliminado exitosamennte!");
    }

    @Override
    public UserDto obtenerPorId(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new RuntimeException("Usuario no entrocntrado");
        }
        return entityUserToDto(user.get());
    }
}
