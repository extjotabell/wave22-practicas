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

    @GetMapping
    public ResponseEntity<List<UserDto>> obtenerTodos(){
        return ResponseEntity.ok(userService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(userService.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespUserDto> eliminarPorId(@PathVariable Long id){
        return ResponseEntity.ok(userService.borrarUser(id));
    }
}
