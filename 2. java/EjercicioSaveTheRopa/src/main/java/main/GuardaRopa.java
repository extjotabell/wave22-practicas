package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private int contador;
    private Map<Integer, List<Prenda>> mapa;

    public GuardaRopa() {
        contador = 0;
        mapa = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contador++;
        mapa.put(contador, listaDePrenda);
        return Integer.valueOf(contador);
    }

    public void mostrarPrendas() {
        mapa.forEach((codigo, valor) -> {
            System.out.println("Codigo: " + codigo);
            System.out.println("Prendas: "+valor.toString());
        });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return mapa.get(numero);
    }


}
