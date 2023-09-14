package org.example;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    List<Cliente> clientes;

    public Repositorio() {
        clientes = new ArrayList<>();
    }

    public void añadirCliente(Cliente cliente){
        clientes.add(cliente);
    }
}
