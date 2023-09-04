package save_the_ropa;

import java.util.*;
import java.util.stream.Collectors;

public class GuardaRopa {
    Integer contador = 0;

    Map<Integer, List<Prenda>> diccionarioPrendas = new HashMap<>();

    public GuardaRopa() {
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

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "contador=" + contador +
                ", diccionarioPrendas=" + diccionarioPrendas +
                '}';
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        this.contador++;
        this.diccionarioPrendas.put(this.contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas() {
        for (Integer key : diccionarioPrendas.keySet()) {
            System.out.println("Código: " + key + " -> Prendas: " + diccionarioPrendas.get(key));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return new ArrayList<>(diccionarioPrendas.get(numero));
    }
}
