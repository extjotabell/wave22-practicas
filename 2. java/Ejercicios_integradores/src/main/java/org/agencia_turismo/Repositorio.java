package org.agencia_turismo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Repositorio {


    private HashMap<Cliente, List<Localizador>> clienteLocalizadores;

    public Repositorio(){
        this.clienteLocalizadores = new HashMap<>();
    }

    public void almacenarLocalizador(Cliente cliente, Localizador localizador){
        if (clienteLocalizadores.containsKey(cliente)){
            clienteLocalizadores.get(cliente).add(localizador);
        }else {
            List<Localizador> list = new ArrayList<>();
            list.add(localizador);
            clienteLocalizadores.put(cliente,list);
        }
    }

    public Integer cantidadLocalizadoresPorCliente(Cliente cliente){//Descuento1
        return this.clienteLocalizadores.get(cliente).size();
    }

    public List<Localizador> localizadoresPorCliente(Cliente cliente) {
        //return localizadores.stream().filter(localizador -> localizador.getCliente().equals(cliente)).collect(Collectors.toList());
        return this.clienteLocalizadores.get(cliente);
    }

}
