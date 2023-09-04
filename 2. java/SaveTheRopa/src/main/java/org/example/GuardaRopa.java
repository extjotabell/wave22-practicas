package org.example;

import org.example.Prendas.Prenda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer contador = 0;
    private Map<Integer, List<Prenda>> diccionarioPrendas = new HashMap<>();

    public GuardaRopa() {
    }

    public GuardaRopa(Map<Integer, List<Prenda>> diccionarioPrendas) {
        this.diccionarioPrendas = diccionarioPrendas;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Map<Integer, List<Prenda>> getDiccionarioPrendas() {
        return diccionarioPrendas;
    }

    public void setDiccionarioPrendas(Map<Integer, List<Prenda>> diccionarioPrendas) {
        this.diccionarioPrendas = diccionarioPrendas;
    }

    public Integer guardarPrendas(List<Prenda> prendas){
        this.contador = this.contador + 1;
        this.diccionarioPrendas.put(this.contador, prendas);
        return contador;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry : diccionarioPrendas.entrySet()) {
            System.out.println("Id: " + entry.getKey() + "-> prendas: " + entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer id){
        return diccionarioPrendas.get(id);
    }

}
