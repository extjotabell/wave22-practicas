package service;

import interfaces.CRUD;
import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService implements CRUD<Cliente,Integer> {
    List<Cliente> clientes;
    @Override
    public boolean alta(Cliente cliente) {
        if (!clientes.contains(cliente)){
            clientes.add(cliente);
            return true;
        }
        else return false;
    }

    @Override
    public boolean baja(Cliente cliente) {
        return clientes.remove(cliente);
    }

    @Override
    public void modificar(Integer dni, Cliente clienteModificado) {
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).getDni()==dni){
                this.clientes.set(i,clienteModificado);
            }
        }
    }


    @Override
    public Cliente consultar(Integer dni) {
        for (Cliente cliente : this.clientes) {
            if (cliente.getDni()==dni) return cliente;
        }
        return null;
    }

    public List<Cliente> getAllClientes() {
        return clientes;
    }

    public ClienteService() {
        this.clientes = new ArrayList<>();
    }
}
