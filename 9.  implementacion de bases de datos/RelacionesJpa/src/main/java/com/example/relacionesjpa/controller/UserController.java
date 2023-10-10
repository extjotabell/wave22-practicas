package com.example.relacionesjpa.controller;

import com.example.relacionesjpa.dto.OneToOne.RespUserDto;
import com.example.relacionesjpa.dto.OneToOne.UserDto;
import com.example.relacionesjpa.service.IUserService;
import com.example.relacionesjpa.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    IUserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<RespUserDto> save(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.guardarUser(userDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        return ResponseEntity.ok(userService.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespUserDto> delete(@PathVariable("id") long userId){
        return new ResponseEntity<>(userService.borrarUser(userId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable("id") long userId, @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.obtenerPorId(userId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") long userId){
        return new ResponseEntity<>(userService.obtenerPorId(userId), HttpStatus.OK);
    }


}
