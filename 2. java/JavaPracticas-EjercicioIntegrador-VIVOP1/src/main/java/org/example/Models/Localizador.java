package org.example.Models;

import org.example.Repository.ClienteRepository;
import org.example.Repository.LocalizadorRepository;

import java.util.List;
public class Localizador {
    private List<PaqueteTuristico> paquetesAdquiridos;
    private Cliente cliente;
    private int porcentajeDescuento;

    public List<PaqueteTuristico> getPaquetesAdquiridos() {
        return paquetesAdquiridos;
    }

    public void setPaquetesAdquiridos(List<PaqueteTuristico> paquetesAdquiridos) {
        this.paquetesAdquiridos = paquetesAdquiridos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public void CalcularPorcentajeDescuento() {
        int localidadoresCount = (int) ClienteRepository.listaClientes.stream()
                .filter(cliente -> cliente.getDni() == getCliente().getDni())
                .count();

        if (localidadoresCount >= 2) {
            setPorcentajeDescuento(getPorcentajeDescuento() + 5);
        }

        boolean[] productoPresente = new boolean[TipoProducto.values().length];
        int cantidadReservasHotel = 0;
        int cantidadBoletosViaje = 0;

        for (var paquete : getPaquetesAdquiridos()) {
            for (var producto : paquete.getProductos()) {
                productoPresente[producto.getTipoProducto().ordinal()] = true;
                if (producto.getTipoProducto() == TipoProducto.HOTEL) {
                    cantidadReservasHotel++;
                } else if (producto.getTipoProducto() == TipoProducto.BOLETO) {
                    cantidadBoletosViaje++;
                }
            }
        }

        if (todosLosProductosPresentes(productoPresente)) {
            setPorcentajeDescuento(getPorcentajeDescuento() + 10);
        }

        if (cantidadReservasHotel >= 2 || cantidadBoletosViaje >= 2) {
            setPorcentajeDescuento(getPorcentajeDescuento() + 5);
        }

    }

    private boolean todosLosProductosPresentes(boolean[] productoPresente) {
        for (boolean presente : productoPresente) {
            if (!presente) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "paquetesAdquiridos=" + paquetesAdquiridos +
                ", cliente=" + cliente +
                ", porcentajeDescuento=" + porcentajeDescuento +
                '}';
    }
}
