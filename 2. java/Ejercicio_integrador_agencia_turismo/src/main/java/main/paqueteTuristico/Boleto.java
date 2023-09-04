package main.paqueteTuristico;

public class Boleto {

    String nombre = "Boleto1";
    double precio = 1500;

    @Override
    public String toString() {
        return "Boleto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
