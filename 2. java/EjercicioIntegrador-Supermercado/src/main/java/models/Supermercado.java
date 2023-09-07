package models;

import Repositories.ClienteRepository;
import Repositories.FacturaRepository;

import java.util.List;
import java.util.Optional;

public class Supermercado implements ClienteRepository, FacturaRepository{
    private String nombre;
    private List<Cliente> clientes;
    private List<Factura> facturas;

    public Supermercado(String nombre, List<Cliente> clientes, List<Factura> facturas) {
        this.nombre = nombre;
        this.clientes = clientes;
        this.facturas = facturas;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public void mostrarClientes(List<Cliente> clientes)
    {
        System.out.println("Mostrando clientes registrados en el sistema:");
        ClienteRepository.clientes(clientes);
    }

    @Override
    public void clientePorDni(int dni) {
        System.out.println("Buscando cliente por dni: ");
        Optional<Cliente> cliente = obtenerClientePorDni(dni);
        if (cliente.isPresent()) System.out.println("Cliente con dni "+ dni +": " +cliente.toString());
        else System.out.println("No se encontro cleinte correspondiente al dni " + dni);

    }

    private Optional<Cliente> obtenerClientePorDni(int dni)
    {
        return clientes.stream().filter(x -> x.getDni() == dni).findFirst();
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        this.clientes.remove(cliente);
    }

    @Override
    public void agregarFactura(Factura factura) {
        System.out.println("Generando factura");
        Optional<Cliente> cliente = obtenerClientePorDni(factura.getCliente().getDni());
        if (cliente.isEmpty())
        {
            System.out.println("No se encontro el cliente " + factura.getCliente().getNombre() + " " + factura.getCliente().getApellido() +  ", en el sistema, añadiendo cliente a la base de datos...");
            this.clientes.add(factura.getCliente());
        }
        //calcular total
       factura.totalCompra = factura.producto.stream().mapToDouble(Producto::getCostoUnitario).sum();
        this.facturas.add(factura);
        System.out.println(factura.toString());
    }
}
