package salvo.nicolas.jewelry.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import salvo.nicolas.jewelry.dto.JewelDTO;
import salvo.nicolas.jewelry.service.IJewelryService;

@RestController
@RequestMapping("/jewelry")
@RequiredArgsConstructor
public class JewelryController {

    private final IJewelryService service;

    @PostMapping("/new")
    public ResponseEntity<?> createJewel(@RequestBody JewelDTO jewelDTO){
        return new ResponseEntity<>(service.create(jewelDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAll() , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewel(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteById(id) , HttpStatus.OK);
    }

}
