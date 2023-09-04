package main;

import java.util.ArrayList;
import java.util.List;

public class RepoCliente {
    private List<Cliente> clientes;

    public RepoCliente() {
        this.clientes = new ArrayList<>();
    }

    public Cliente buscarCliente(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente agregarCliente(String nombre) {
        Cliente clienteExistente = buscarCliente(nombre);
        if (clienteExistente != null) {
            return clienteExistente;
        }
        Cliente nuevoCliente = new Cliente(nombre);
        clientes.add(nuevoCliente);
        return nuevoCliente;
    }
}





