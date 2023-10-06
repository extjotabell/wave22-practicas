package com.meli.joyerialasperlas.controller;

import com.meli.joyerialasperlas.dto.JoyaDTO;
import com.meli.joyerialasperlas.service.JoyaServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
public class JoyaController {

    private final JoyaServiceImp joyaServiceImp;

    public JoyaController(JoyaServiceImp joyaServiceImp) {
        this.joyaServiceImp = joyaServiceImp;
    }

    // 1. Crear una nueva joya y devolver el nro identificatorio
    @PostMapping("/new")
    public ResponseEntity<?> save(@RequestBody JoyaDTO joyaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(joyaServiceImp.save(joyaDTO));
    }

    // 2. Devolver el listado de todas las joyas registradas
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(joyaServiceImp.getAll());
    }

    // 3. Eliminar lógicamente una joya
    @PatchMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        return  ResponseEntity.status(HttpStatus.OK).body(joyaServiceImp.delete(id));
    }

    //4. Actualizar los datos de una joya
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody JoyaDTO joyaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(joyaServiceImp.update(id, joyaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(joyaServiceImp.getById(id));
    }


}
