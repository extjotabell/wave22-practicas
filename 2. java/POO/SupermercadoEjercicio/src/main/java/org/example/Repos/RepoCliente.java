package org.example.Repos;

import org.example.Cliente;
import org.example.ICrudCliente;

import java.util.ArrayList;
import java.util.List;

public class RepoCliente implements ICrudCliente {

    private List<Cliente> clientesCollection = new ArrayList<>();

}
