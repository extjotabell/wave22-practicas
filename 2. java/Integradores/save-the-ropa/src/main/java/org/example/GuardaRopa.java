package org.example;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> diccionario;
    private Integer key;

    public GuardaRopa() {
        this.diccionario = new HashMap<>();
        this.key = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        this.key += 1;
        this.diccionario.put(this.key, listaDePrendas);
        return this.key;
    }

    public void mostrarPrendas(){
        diccionario.forEach((key,value)-> System.out.println("Clave: " + key + " - "+ "Valor: " + value));
    }

    public List<Prenda> devolverPrenda(Integer numero){
        return diccionario.get(numero);
    }
}
