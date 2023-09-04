package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository implements Crud<Cliente> {

    private List<Cliente> clienteList;

    public ClienteRepository() {
        this.clienteList = new ArrayList<>();
    }

    @Override
    public void create(Cliente obj) {
        this.clienteList.add(obj);
    }

    @Override
    public Optional<Cliente> read(String id) {
        return this.clienteList.stream().filter(c -> c.getDni().equals(id)).findFirst();
    }

    @Override
    public void update(Cliente obj) {
        clienteList.removeIf(c->c.getDni().equals(obj.getDni()));
        clienteList.add(obj);
    }

    @Override
    public void delete(String id) {
        this.clienteList.removeIf(cliente-> cliente.getDni().equals(id));
    }

    @Override
    public List<Cliente> getAll() {
        return this.clienteList;
    }
}
