package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> map = new HashMap();
    private int indice = 0;

    public GuardaRopa() {
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    public int guardarPrendas(List<Prenda> listaPrendas){
        map.put(indice,listaPrendas);
        setIndice(indice+1);
        return indice-1;
    }

    public void mostrarPrendas(){
        map.forEach((key,value)->System.out.println(key+value.toString()));
    }

    public List<Prenda> devolverPrendas(int numeroRecibido) {
        return map.get(numeroRecibido);
    }

}
