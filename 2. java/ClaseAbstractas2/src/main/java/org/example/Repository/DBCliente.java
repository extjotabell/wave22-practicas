package org.example.Repository;

import org.example.Class.Cliente;

import java.util.List;

public class DBCliente {
    List<Cliente> ClienteDb;

    public DBCliente(List<Cliente> clienteDb) {
        ClienteDb = clienteDb;
    }
    public DBCliente(){};

    public List<Cliente> getClienteDb() {
        return ClienteDb;
    }

    public void setClienteDb(List<Cliente> clienteDb) {
        ClienteDb = clienteDb;
    }


}
