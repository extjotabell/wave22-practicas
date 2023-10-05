package jewelry.jewerly.controller;

import jewelry.jewerly.dto.JewelDto;
import jewelry.jewerly.dto.MessageDto;
import jewelry.jewerly.model.Jewel;
import jewelry.jewerly.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    IJewelService service;

    @PostMapping("/jewerly/new")
    public ResponseEntity<MessageDto> createJewel(@RequestBody JewelDto jewel){
        return new ResponseEntity<>(new MessageDto("Jewel created with id: " + service.createJewel(jewel)), HttpStatus.CREATED);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<JewelDto>> getJewels(){
        return new ResponseEntity<>(service.getJewels(), HttpStatus.OK);
    }

    @PostMapping("/jewerly/delete/{id}")
    public ResponseEntity<MessageDto> deleteJewel(@PathVariable long id){
        service.deleteJewel(id);
        return new ResponseEntity<>(new MessageDto("Jewel deleted successfully"), HttpStatus.OK);
    }

    @PostMapping("/jewerly/update/{id}")
    public ResponseEntity<MessageDto> updateJewel(@PathVariable long id,
                                         @RequestBody JewelDto jewel){
        service.updateJewel(id, jewel);
        return new ResponseEntity<>(new MessageDto("Jewel updated successfully"), HttpStatus.OK);
    }
}
