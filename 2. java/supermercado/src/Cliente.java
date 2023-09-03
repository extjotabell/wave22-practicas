public class Cliente {
    String DNI;
    String nombre;
    String apellido;

    public Cliente(String DNI, String nombre, String apellido) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
