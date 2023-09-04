package org.example.Models;

import java.util.List;
public class PaqueteTuristico {
    private List<Producto> productos;

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "PaqueteTuristico{" +
                "productos=" + productos +
                '}';
    }
}
