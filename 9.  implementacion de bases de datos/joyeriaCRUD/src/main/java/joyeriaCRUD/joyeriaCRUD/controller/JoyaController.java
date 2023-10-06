package joyeriaCRUD.joyeriaCRUD.controller;

import joyeriaCRUD.joyeriaCRUD.dto.JoyaDto;
import joyeriaCRUD.joyeriaCRUD.service.JoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    private final JoyaService service;

    public JoyaController(JoyaService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<?> save(@RequestBody JoyaDto joya){
        return ResponseEntity.ok(service.saveJoya(joya));
    }

    @GetMapping("/")
    public ResponseEntity<?> findAllJoyas(){
        return ResponseEntity.ok(service.getJoyas());
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteJoya(@PathVariable Long id){
        service.deleteJoya(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update/{id_modificar}")
    public ResponseEntity<?> update(@PathVariable Long id_modificar, @RequestBody JoyaDto joya){
        return ResponseEntity.ok(service.update(id_modificar, joya));
    }

}
