package repository.impl;

import model.Cliente;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImpl implements Repository<Cliente> {

    List<Cliente> clienteList = new ArrayList<Cliente>();
    @Override
    public void save(Cliente objeto) {

    }

    @Override
    public void mostrarPantalla() {

    }

    @Override
    public Optional<Cliente> buscar(Cliente cliente) {
        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {

    }
}
