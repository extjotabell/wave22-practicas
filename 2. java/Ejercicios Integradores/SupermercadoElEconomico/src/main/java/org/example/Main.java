package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase();
        db.alta(new Cliente("32453199", "Justin", "Bieber"));
        db.alta(new Cliente("30747910", "Lionel", "Messi"));
        db.alta(new Cliente("33213121", "Taylor", "Swift"));

        db.consultarTodo(1);

        db.baja(db.consulta(1,"32453199"));
        System.out.println("\nLista clientes post remove:");
        db.consultarTodo(1);

        Scanner input = new Scanner(System.in);
        System.out.println("\nIngrese un DNI para buscarlo en la lista de clientes:");
        String dniABuscar = input.next();
        if(db.consulta(1, dniABuscar) != null){
            System.out.println(db.consulta(1, dniABuscar));
        }
        else{
            System.out.println("El DNI no existe en BD");
        }

        //-----------------------SPRINT 2-----------------------

        List<Item> items = new ArrayList<>();
        Cliente cliente = new Cliente("221", "Margot", "Robbie");
        items.add(new Item(1,"Yogurth", 2, 300));
        items.add(new Item(5, "Oreos", 1, 500));
        items.add(new Item(75, "Creatina", 2, 15000));

        db.alta(new Factura(1, cliente, items, items.stream()
                .mapToDouble(Item::getCostoTotal)
                .sum()));

        List<Cliente> listaDeClientes = db.consultarTodo(1);
        Factura factura = (Factura) db.consulta(2,1);

        if(!listaDeClientes.contains(factura.getCliente())){
            db.alta(factura.getCliente());
            System.out.println("Cliente añadido a la base de datos");
        }
        db.consultarTodo(1);
        db.consultarTodo(2);
    }
}