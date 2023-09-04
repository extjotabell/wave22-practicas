package main.paqueteTuristico;

public class PaqueteCompleto {

    String nombre = "Paquete Completo";

     double precio = 5000;


    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "PaqueteCompleto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
