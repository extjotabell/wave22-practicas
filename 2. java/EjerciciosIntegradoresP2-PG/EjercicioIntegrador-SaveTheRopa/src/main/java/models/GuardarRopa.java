package models;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {
    private int contador;
    Map<Integer, List<Prenda>> diccionarioRopa = new HashMap<Integer, List<Prenda>>();

    public GuardarRopa() {
    }

    public Map<Integer, List<Prenda>> getDiccionarioRopa() {
        return diccionarioRopa;
    }

    public void setDiccionarioRopa(Map<Integer, List<Prenda>> diccionarioRopa) {
        this.diccionarioRopa = diccionarioRopa;
    }

    public Integer guardarPrendas(List<Prenda> listaPrenda)
    {
        diccionarioRopa.put(contador++, listaPrenda);
        return contador++;
    }
    public void mostrarPrendas()
    {
        this.diccionarioRopa.entrySet().stream().forEach(ropa -> System.out.println("Clave: " + ropa.getKey() + " - Ropa: " + ropa.getValue().toString()));
    }

    public List<Prenda> devolverPrendas(Integer numero)
    {
        System.out.println("Devolviendo ropa con la clave " + numero);
        return this.diccionarioRopa.get(numero);
    }

}
