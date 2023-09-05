package com.renzobayarri.morsecode.controller;

import com.renzobayarri.morsecode.services.MorseCodeDecoder;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MorseCodeController {

    MorseCodeDecoder decoder;

    @GetMapping("/decode")
    public String decode(@RequestParam String morseCode) {
        return decoder.decode(morseCode);
    }

    @GetMapping("/encode")
    public String encode(@RequestParam String phrase) {
        return decoder.encode(phrase);
    }
}
