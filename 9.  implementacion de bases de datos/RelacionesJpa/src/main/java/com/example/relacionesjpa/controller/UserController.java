package com.example.relacionesjpa.controller;

import com.example.relacionesjpa.dto.OneToOne.RespUserDto;
import com.example.relacionesjpa.dto.OneToOne.UserDto;
import com.example.relacionesjpa.entity.OneToOne.User;
import com.example.relacionesjpa.service.IUserService;
import com.example.relacionesjpa.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    IUserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardarUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.guardarUser(userDto), HttpStatus.OK);
    }

    //gelAll
    @GetMapping()
    public ResponseEntity<List<UserDto>> getAll(){
        return ResponseEntity.ok(userService.buscarTodos());
    }

    //getbyId
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id)
    {
        return new ResponseEntity<>(userService.obtenerPorId(id), HttpStatus.OK);
    }

    //update
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.actualizarUsuario(userDto), HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RespUserDto> deleteUserById(@PathVariable Long id)
    {
        return new ResponseEntity<>(userService.borrarUser(id), HttpStatus.OK);
    }
}
