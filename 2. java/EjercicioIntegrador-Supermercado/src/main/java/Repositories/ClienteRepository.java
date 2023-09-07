package Repositories;
import java.util.List;
import java.util.stream.Collectors;

import models.Cliente;

public interface ClienteRepository {
    static void clientes(List<Cliente> clientes)
    {
        System.out.println(clientes.stream().map(Cliente::toString).collect(Collectors.toList()));
    }
    void clientePorDni(int dni);
    void eliminarCliente(Cliente cliente);

}
