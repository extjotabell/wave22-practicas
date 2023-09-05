package org.example.Interfaces;

import org.example.clases.Cliente;
import org.example.clases.Factura;

public interface crud {
    void alta(Cliente cliente);
    void baja(Cliente cliente);
    void actualizacion(Cliente cliente, Factura factura);
    void lectura(String dni);
}
