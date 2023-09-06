package supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {


    //Para estar en la misma instancia del clienteCRUD, itemCRUD y facturaCRUD. Tengo que pasar la implementación
    // de la interfaz y los listados por parámetro dentro de la función
    public static void agregarFactura(Factura factura, List<Cliente> listaClientes, List<Item> listaItems, InterfaceCRUD<Factura> facturaCRUD){

        //Check existencia cliente
        boolean existeCliente = listaClientes.stream().anyMatch(cliente -> cliente.getDni().equals(factura.getCliente().getDni()));
        if(!existeCliente){
            listaClientes.add(factura.getCliente());
        }

        //Crear lista items y asociarla a la factura
        factura.setListaItems(listaItems);

        //calcular total
        double total = 0;
        total = listaItems.stream().mapToDouble(item -> item.getCantidadComprada() * item.getCostoUnitario()).sum();
        factura.setTotal(total);
        facturaCRUD.alta(factura);
    }

    public static void main(String[] args) {

        InterfaceCRUD<Factura> facturaCRUD = new FacturaCRUDImpl();
        InterfaceCRUD<Cliente> clienteCRUD = new ClienteCRUDImpl();
        InterfaceCRUD<Item> itemCRUD = new ItemCRUDImpl();

        Scanner scanner = new Scanner(System.in);

        //****************Alta de clientes****************
        clienteCRUD.alta(new Cliente("12345678", "Facundo", "Hermida"));
        clienteCRUD.alta(new Cliente("42596009", "Marcos", "Alonso"));
        clienteCRUD.alta(new Cliente("40599303", "Celina", "Fernandez"));


        //****************Listado de clientes****************
        System.out.println("Clientes:");

        List<Cliente> listaClientes = clienteCRUD.obtenerTodos();
        listaClientes.forEach(System.out::println);


        //****************Consulta por DNI*******************
        System.out.println("\nIngrese un DNI para consultar:");
        String dniConsulta = scanner.next();
        System.out.println("Resultado de la consulta: "+clienteCRUD.consulta(Integer.parseInt(dniConsulta)));


        //*******************Parte 2************************

        //****************Alta de items****************
        itemCRUD.alta(new Item(1, "Leche", 3, 500));
        itemCRUD.alta(new Item(2, "Maple huevos", 1, 3000));
        itemCRUD.alta(new Item(3, "Lay's", 2, 1200));

        Factura factura = new Factura(listaClientes.get(0));
        Factura factura1 = new Factura(listaClientes.get(1));

        agregarFactura(factura, clienteCRUD.obtenerTodos(), itemCRUD.obtenerTodos(), facturaCRUD);
        agregarFactura(factura1, clienteCRUD.obtenerTodos(), itemCRUD.obtenerTodos(), facturaCRUD);

        System.out.println("Mostrando listado de facturas...");
        facturaCRUD.obtenerTodos().forEach(System.out::println);

    }
}
