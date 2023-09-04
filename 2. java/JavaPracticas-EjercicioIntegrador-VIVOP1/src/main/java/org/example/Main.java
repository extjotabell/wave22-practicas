package org.example;

import org.example.Models.Cliente;
import org.example.Models.Localizador;
import org.example.Models.PaqueteTuristico;
import org.example.Models.Producto;
import org.example.Repository.ClienteRepository;
import org.example.Repository.LocalizadorRepository;

import java.util.ArrayList;
import java.util.List;

import static org.example.Models.TipoProducto.*;

public class Main {
    public static void main(String[] args) {

        //PRODUCTOS

        Producto producto1 = new Producto(HOTEL);
        Producto producto2 = new Producto(COMIDA);
        Producto producto3 = new Producto(BOLETO);
        Producto producto4 = new Producto(TRANSPORTE);

        //PAQUETES

        PaqueteTuristico nuevoPaquete = new PaqueteTuristico();

        List<Producto> productos = new ArrayList<>();

        productos.add(producto1);
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);

        nuevoPaquete.setProductos(productos);

        List<PaqueteTuristico> paqueteTuristicos = new ArrayList<>();

        paqueteTuristicos.add(nuevoPaquete);

        //CLIENTE

        Cliente nuevoCliente = new Cliente(123, "Pepe");

        ClienteRepository.listaClientes.add(nuevoCliente);

        //LOCALIZADOR

        Localizador nuevoLocalizador = new Localizador();

        nuevoLocalizador.setPaquetesAdquiridos(paqueteTuristicos);
        nuevoLocalizador.setCliente(nuevoCliente);

        LocalizadorRepository.listaLocalizadores.add(nuevoLocalizador);

        nuevoLocalizador.CalcularPorcentajeDescuento();

        System.out.println(nuevoLocalizador.toString());
    }
}