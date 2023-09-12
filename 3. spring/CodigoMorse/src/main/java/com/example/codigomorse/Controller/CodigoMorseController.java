package com.example.codigomorse.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.codigomorse.MorseDictionary;
import java.util.Map;

@RestController
public class CodigoMorseController {

    Map<String, String> morseDictionary = new MorseDictionary().getDictionary();

    @GetMapping("/convertToSpanish")
    public String convert(@RequestParam String str){
        StringBuilder convertedString = new StringBuilder();
        String[]  arr = str.replace("   ", " * ").split(" ");
        for (String character :
                arr) {
            convertedString.append(morseDictionary.get(character));

        }
        return convertedString.toString();
    }

}