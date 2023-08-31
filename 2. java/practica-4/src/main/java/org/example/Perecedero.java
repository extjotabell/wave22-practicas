package org.example;

public class Perecedero extends Producto{
    private Integer diasPorCaducar;
    public Perecedero(String nombre, double precio, Integer diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(Integer cantidadProducto) {
        double precioBase= super.calcular(cantidadProducto);
        if(diasPorCaducar > 3){
            return precioBase;
        } else if(diasPorCaducar == 3){
            return precioBase/2;
        } else if(diasPorCaducar == 2){
            return precioBase/3;
        } else{
            return precioBase/4;
        }

    }

    @Override
    public String toString() {
        return "Perecedero: " +
                "nombre: " + super.getNombre() +
                "precio: " + super.getPrecio() +
                "diasPorCaducar: " + diasPorCaducar;
    }
}
