package services;

import dao.entity.Cliente;

import java.util.List;

public interface ClienteService {
    void setClientes(List<Cliente> clientes);
    void getClientes();
    void deleteByDni(String dni);
    Cliente findById(String dni);
}
