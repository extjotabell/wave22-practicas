import model.Cliente;
import model.Factura;
import model.Item;
import service.ClienteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Bonus
        Cliente cliente1 = new Cliente(123,"Gaspar","Zanini");
        Cliente cliente2 = new Cliente(456,"Pepe","Fuentes");
        Cliente cliente3 = new Cliente(789,"Juan","Perez");
        ClienteService clienteService = new ClienteService();
        clienteService.alta(cliente1);
        clienteService.alta(cliente2);
        clienteService.alta(cliente3);

        //Parte1
        System.out.println("Punto3");
        clienteService.getAllClientes().forEach(System.out::println);
        clienteService.baja(cliente2);
        System.out.println("Punto4");
        clienteService.getAllClientes().forEach(System.out::println);
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese dni a buscar: ");
        int dniABuscar = sc.nextInt();
        Cliente clienteABuscar = clienteService.consultar(dniABuscar);
        if (clienteABuscar!=null) {
            System.out.println(clienteABuscar);
        }
        else System.out.println("No existe el cliente buscado");

        //Parte2
        Cliente cliente4 = new Cliente(1234,"Jorge", "Martinez");
        clienteService.alta(cliente4);
        Item item1 = new Item(1,"Jamon",5,100);
        Item item2 = new Item(2,"Queso",4,150);
        List<Item> itemsFactura1 = new ArrayList<>();
        itemsFactura1.add(item1);
        itemsFactura1.add(item2);
        Factura factura1 = new Factura(cliente4,itemsFactura1);
        factura1.calcularTotal();
        System.out.println("El total de la factura es de: "+factura1.getTotalCompra());

    }
}