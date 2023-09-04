public class Cliente {

    private int dni;
    private String nombre;
    private String apellido;

    public boolean dniEquals(int dniToCompare) {
        return dni == dniToCompare;
    }

    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
