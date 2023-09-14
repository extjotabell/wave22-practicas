package org.example.Class;

import java.util.List;

public class Factura {
    public Cliente cliente;
    public List<Producto> ListaProducto;
    public String IdFactura;

    public Factura(Cliente cliente, List<Producto> listaProducto, String idFactura) {
        this.cliente = cliente;
        ListaProducto = listaProducto;
        IdFactura = idFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getListaProducto() {
        return ListaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        ListaProducto = listaProducto;
    }

    public String getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(String idFactura) {
        IdFactura = idFactura;
    }

    public void GetTotalFactura(){
        double precioFinal = 0 ;
        for (Producto producto: this.ListaProducto) {
            precioFinal +=  producto.getPrecio();
        }
        System.out.println("Precio Final de la factura: " + precioFinal);
    }
}
