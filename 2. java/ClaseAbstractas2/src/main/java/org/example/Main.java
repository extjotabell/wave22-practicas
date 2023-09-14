package org.example;

import org.example.Class.Cliente;
import org.example.Class.Factura;
import org.example.Class.Producto;
import org.example.Repository.DBCliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Cliente> clienteList = new ArrayList<>();

        clienteList.add(new Cliente("35756263", "Solange", "Recayte"));
        clienteList.add(new Cliente("59561709","Noah","Fimiani"));
        clienteList.add(new Cliente("33982734", "Orion", "Gonzales"));

        System.out.println("Lista de Cliente");
        for(Cliente cliente : clienteList){
            System.out.println(cliente.toString());
        }

        clienteList.remove(1);
        System.out.println("Se elimino un cliente de la listaz");
        for(Cliente cliente : clienteList){
            System.out.println(cliente.toString());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar un dni para buscar");
        String DniBuscar =scanner.next();

        Cliente ClienteEncontrado = clienteList.stream().filter(x -> x.getDNI().equals(DniBuscar)).findFirst().get();
        System.out.println(ClienteEncontrado);
        if(ClienteEncontrado  != null) {
            System.out.println(ClienteEncontrado);
        }
        else {
            System.out.println("No existe cliente");
        }

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("001","Yogur",2,10.5));
        productos.add(new Producto("002","Leche",5,20));
        productos.add(new Producto("003","queso",13,33.3));

        Factura factura1 = new Factura(new Cliente("35756263", "Solange", "Recayte"),productos,"nro001");

        //String dniFactura = factura1.getCliente().getDNI();
        //DBCliente dbCliente = new DBCliente();

        //List<Cliente> ListaCliente = dbCliente.getClienteDb();

        //Cliente clienteExiste=  ListaCliente.stream().filter(x -> x.getDNI().equals(dniFactura)).findFirst().get();
        //if(clienteExiste ==null){
        //    ListaCliente.add(clienteExiste);
        //}
        factura1.GetTotalFactura();



    }
}