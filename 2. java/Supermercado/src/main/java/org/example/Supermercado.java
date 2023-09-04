package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Supermercado {
    private FacturaRepository facturaRepository;
    private ClienteRepository clienteRepository;

    public Supermercado() {
        this.facturaRepository = new FacturaRepository();
        this.clienteRepository = new ClienteRepository();
    }

    public void agregarCliente(Cliente c){
        this.clienteRepository.create(c);
    }

    public List<Cliente> getClientes() {
        return this.clienteRepository.getAll();
    }

    public void mostrarClientes() {
        System.out.println(this.clienteRepository.getAll());
    }

    public void borrarCliente(String dni){
        this.clienteRepository.delete(dni);
    }

    public Cliente buscarCliente(String dni){
        Optional<Cliente> cliente = this.clienteRepository.read(dni);
        if(cliente.isPresent()){
            System.out.println(cliente);
            return cliente.get();
        } else {
            System.out.println("No se encontro un cliente");
            return null;
        }
    }

    public Factura crearFactura(Cliente c, List<Item> items, String codigo){
        if(!validarCliente(c)){
            this.agregarCliente(c);
        }

        Factura factura = new Factura(items, c, codigo);
        this.facturaRepository.create(factura);

        return factura;
    }

    private boolean validarCliente(Cliente c){
        return this.buscarCliente(c.getDni()) != null;
    }
}
