package org.example.repository;

import org.example.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrudCliente implements Crud<Cliente> {

    List<Cliente> clienteList = new ArrayList<>();
    @Override
    public Cliente save(Cliente nuevo) {

        clienteList.add(nuevo);
        return nuevo;
    }

    @Override
    public void delete(int dni) {
        clienteList = clienteList.stream().filter(clie -> clie.getDni().equals(dni)).collect(Collectors.toList());
    }

    @Override
    public List<Cliente> getAll() {
        return clienteList;
    }
}
