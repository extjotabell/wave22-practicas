package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class RepositorioClientes {

    private List<Cliente> listaDeClientes;

    public RepositorioClientes() {
        listaDeClientes = new ArrayList<>();
    }

    public List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeLocalizadores(List<Cliente> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }

    public void agregarCliente(Cliente clienteAAgregar){
        listaDeClientes.add(clienteAAgregar);
    }
}
