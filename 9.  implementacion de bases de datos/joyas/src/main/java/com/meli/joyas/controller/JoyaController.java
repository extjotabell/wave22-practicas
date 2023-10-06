package com.meli.joyas.controller;

import com.meli.joyas.dto.JoyaDto;
import com.meli.joyas.model.Joya;
import com.meli.joyas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class JoyaController {
    @Autowired
    IJoyaService joyaService;
    @PostMapping("/jewerly/new")
    public String saveJoya (@RequestBody JoyaDto joya) {
        return joyaService.createJoya(joya);
    }

    @GetMapping("/jewerly")
    public List<Joya> getJoyas () {

        return joyaService.getAllJoyas();
    }
    @PutMapping("/jewerly/delete/{id}")
    public String deleteJoya (@PathVariable Long id) {

        return joyaService.deleteJoya(id);
    }

    @PutMapping ("/jewerly/update/{id}")
    public Joya editJoya (@PathVariable Long id,
                            @RequestBody JoyaDto joya) {

        return joyaService.updateJoya(id, joya);
    }
}
