package com.mleiva.relacionesjpa.controller;

import com.mleiva.relacionesjpa.dto.OneToOne.UserDto;
import com.mleiva.relacionesjpa.service.IUserService;
import com.mleiva.relacionesjpa.service.UserService;
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
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.buscarTodos(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id){
        return new ResponseEntity<>(userService.borrarUser(id),HttpStatus.OK);
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id){
        return new ResponseEntity<>(userService.obtenerPorId(id),HttpStatus.OK);
    }

}
