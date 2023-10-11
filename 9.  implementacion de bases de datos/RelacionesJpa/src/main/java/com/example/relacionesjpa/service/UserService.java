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
    ModelMapper mapper = new ModelMapper();

    public UserService(UserRepository userRepository, AddressRepository addressRepository){
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<UserDto> buscarTodos() {
        List<User> users = userRepository.findAll();
        return  users.stream().map(user -> mapper.map(user, UserDto.class)).collect(Collectors.toList());
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
        Optional<User> optUser = userRepository.findById(id);
        User user = new User();
        if(optUser.isPresent()){
            user = optUser.get();
        }
        userRepository.delete(user);
        UserDto userDto = mapper.map(user, UserDto.class);
        return new RespUserDto(userDto, "Se eliminó correctamente el usuario");

    }

    @Override
    public UserDto obtenerPorId(Long id) {
        Optional<User> user = userRepository.findById(id);
        if( user.isPresent() ){
            return mapper.map(user.get(), UserDto.class);
        }
        return null;
    }

    public RespUserDto actualizarUser(Long id, UserDto userDto) {
        Optional<User> optUser = userRepository.findById(id);
        if(optUser.isPresent()) {
            User userChange = mapper.map(userDto, User.class);
            User userPersist = optUser.get();
            userPersist.setAddress(userChange.getAddress());
            userPersist.getAddress().setUser(userPersist);
            userRepository.save(userPersist);
            UserDto userReturn = mapper.map(userPersist, UserDto.class);
            return new RespUserDto(userReturn, "Se modificó correctamente el usuario");
        }
        return null;
    }
}
