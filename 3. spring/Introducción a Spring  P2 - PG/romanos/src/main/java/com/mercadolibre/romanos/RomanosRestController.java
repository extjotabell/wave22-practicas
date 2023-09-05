package com.mercadolibre.romanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import  java.util.TreeMap;

@RestController
public class RomanosRestController {

  private static final Map<Integer, String> numerosRomanos = new TreeMap<>();

  static {
    numerosRomanos.put(1, "I");
    numerosRomanos.put(2, "II");
    numerosRomanos.put(3, "III");
    numerosRomanos.put(4, "IV");
    numerosRomanos.put(5, "V");
    numerosRomanos.put(7, "VII");
    numerosRomanos.put(10, "X");
    numerosRomanos.put(50, "L");
    numerosRomanos.put(100, "C");
    numerosRomanos.put(500, "D");
    numerosRomanos.put(1000, "M");
  }

  @GetMapping("/numeroRomano")
  public String getNumeroRomanoAsociado(@RequestParam Integer numero) {
    StringBuilder resultado = new StringBuilder();

    while (numero > 0) {
      int claveMayorIgual = 0;
      String simbolo = "";

      // Encontrar la clave mayor o igual más grande
      for (int clave : numerosRomanos.keySet()) {
        if (clave <= numero && clave > claveMayorIgual) {
          claveMayorIgual = clave;
          simbolo = numerosRomanos.get(clave);
        }
      }

      resultado.append(simbolo);
      numero -= claveMayorIgual;
    }

    return resultado.toString();
  }
}
