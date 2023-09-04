package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private int contador;

    private Map<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
        this.contador = 0;
        this.prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contador++;
        this.prendas.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas() {
        System.out.println("Prendas en Guardaropa");
        prendas.forEach((id, lista) -> {
            System.out.println("Identificador: " + id);
            System.out.println("Prendas: ");
            lista.forEach(System.out::println);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prendasADevolver = prendas.get(numero);
        prendas.remove(numero);
        return prendasADevolver;
    }
}
