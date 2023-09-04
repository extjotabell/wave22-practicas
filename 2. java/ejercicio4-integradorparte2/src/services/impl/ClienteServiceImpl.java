package services.impl;

import dao.entity.Cliente;
import services.ClienteService;

import java.util.List;
import java.util.Objects;

public class ClienteServiceImpl implements ClienteService {
    private List<Cliente> clientes;

    @Override
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public void getClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    @Override
    public void deleteByDni(String dni) {
       clientes.remove(findById(dni));
        System.out.println("Cliente borrado con exito!");
    }

    @Override
    public Cliente findById(String dni) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (Objects.equals(cliente.getDni(), dni)) {
                clienteEncontrado = cliente;
            }
        }
        if (clienteEncontrado == null) {
            System.out.println("No se encontro el cliente con el dni proporcionado.");
        }
        return clienteEncontrado;
    }
}
