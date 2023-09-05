package org.example.clases;

import org.example.Interfaces.crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Gestor implements crud {

    private Map<String,Cliente> clientes = new HashMap<>();;
    private Map<String, ArrayList<Factura>> facturas = new HashMap<>();;


    @Override
    public void alta(Cliente cliente) {
        if(!this.clientes.containsKey(cliente.getDni())){
            this.clientes.put(cliente.getDni(),cliente);
            ArrayList<Factura> listafacturas= new ArrayList<>();
            this.facturas.put(cliente.getDni(),listafacturas);
        }else{
            System.out.println("Cliente ya existente!");
        }
    }

    @Override
    public void baja(Cliente cliente) {
        if(this.clientes.containsKey(cliente.getDni())){
            this.clientes.remove(cliente.getDni());
            this.clientes.remove(cliente.getDni());
        }else {
            System.out.println("Cliente no encontrado!");
        }
    }

    @Override
    public void actualizacion(Cliente cliente, Factura factura) {
        if(this.clientes.containsKey(cliente.getDni())){
            this.facturas.get(cliente.getDni()).add(factura);
        }else {
            System.out.println("Cliente no encontrado!");
        }
    }

    @Override
    public void lectura(String dni) {
        if(this.clientes.containsKey(dni)){
            System.out.println(this.clientes.get(dni));
        }else {
            System.out.println("CLiente no encontrado");
        }
    }

    public void generarCompra(Cliente cliente, ArrayList<Item> items){
        if(!this.clientes.containsKey(cliente.getDni())){
            this.alta(cliente);
        }
        Factura factura = new Factura(cliente, items);
        this.actualizacion(cliente,factura);
    }

    public void verFacturas(Cliente cliente){
        if(this.clientes.containsKey(cliente.getDni())){
            for (Factura factura: this.facturas.get(cliente.getDni())) {
                System.out.println(factura);
            }
        }else {
            System.out.println("CLiente no encontrado");
        }
    }
}
