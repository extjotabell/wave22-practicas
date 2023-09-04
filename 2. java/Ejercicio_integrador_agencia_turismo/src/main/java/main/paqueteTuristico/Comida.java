package main.paqueteTuristico;

public class Comida {

    String nombre = "Asado";
    double precio = 1000;

    @Override
    public String toString() {
        return "Comida{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
