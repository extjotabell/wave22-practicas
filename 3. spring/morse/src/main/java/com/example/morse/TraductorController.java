package com.example.morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("traductor")
public class TraductorController {
    @GetMapping
    public String toString(@RequestParam String text){
        return MorseCode.translate(text);
    }
}
