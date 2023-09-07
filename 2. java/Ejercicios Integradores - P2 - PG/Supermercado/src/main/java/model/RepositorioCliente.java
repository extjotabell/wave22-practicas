package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RepositorioCliente implements CRUD {
    public RepositorioCliente() {
    }


    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void create(Object o) {
        clientes.add((Cliente) o);
    }

    @Override
    public void delete(int id) {
        clientes = clientes.stream().filter(cliente -> cliente.getDni() != id).collect(Collectors.toList());
    }

    @Override
    public void update(int id, Object newObj) {
        Optional<Cliente> cliente = clientes.stream().filter(client -> client.getDni() == id).findFirst();

        if (cliente.isPresent()) {
            int index = clientes.indexOf(cliente.get());
            clientes.set(index, (Cliente) newObj);
        }
    }

    @Override
    public List<Cliente> getAll() {
        return clientes;
    }

    @Override
    public Object getObjectById(int id) {
        return clientes.stream().filter(cliente -> cliente.getDni() == id).findFirst().orElse(null);
    }
}
