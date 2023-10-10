package com.example.relacionesjpa.controller;

import com.example.relacionesjpa.dto.OneToOne.UserDto;
import com.example.relacionesjpa.service.IUserService;
import com.example.relacionesjpa.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/")
    public ResponseEntity<?> buscar(){
        return new ResponseEntity<>(userService.buscarTodos(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarById(@PathVariable Long id){
        return new ResponseEntity<>(userService.obtenerPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        return new ResponseEntity<>(userService.borrarUser(id), HttpStatus.OK);
    }
}