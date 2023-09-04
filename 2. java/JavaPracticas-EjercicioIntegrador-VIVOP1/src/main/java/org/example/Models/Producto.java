package org.example.Models;

public class Producto {

    private TipoProducto tipoProducto;

    public Producto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "tipoProducto=" + tipoProducto +
                '}';
    }
}
