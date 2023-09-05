package org.example.SaveTheRopa.Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> diccionario;
    private int contador;

    public GuardaRopa() {
        diccionario = new HashMap<>();
        contador = 0;
    }
    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        diccionario.put(contador, listaDePrenda);
        return contador++;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : diccionario.entrySet()) {
            Integer identificador = entry.getKey();
            List<Prenda> prendas = entry.getValue();

            System.out.println("Identificador: " + identificador);
            for (Prenda prenda : prendas) {
                System.out.println("Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return diccionario.get(numero);
    }

}
