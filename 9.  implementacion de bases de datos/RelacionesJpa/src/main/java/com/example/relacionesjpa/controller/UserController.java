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

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.obtenerPorId(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> buscarTodosUsers(){
        return new ResponseEntity<>(userService.buscarTodos(), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.borrarUser(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> actualizarUser(@PathVariable Long id, @RequestBody UserDto newUserDto){
        return new ResponseEntity<>(userService.actualizarUser(id, newUserDto), HttpStatus.OK);
    }

    // CRUD Create Read Update Delete
}
