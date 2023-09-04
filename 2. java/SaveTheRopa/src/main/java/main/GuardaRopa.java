package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> prendas;
    private  int contador;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        prendas.put(contador,listaDePrenda);
        contador+=1;
        return contador;
    }

    public void mostrarPrendas(){
        prendas.forEach((key,value)->{
            System.out.println("Numero: "+key+" Prendas: "+value);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> devolucion = new ArrayList<>();
        if(prendas.containsKey(numero)){
            devolucion = prendas.get(numero);
            prendas.remove(numero);
        }else {
            System.out.println("numero no encontrado");
        }
        return devolucion;
    }


}