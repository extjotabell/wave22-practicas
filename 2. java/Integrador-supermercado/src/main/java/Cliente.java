import java.util.Collection;

public class Cliente {
    int dni;
    String nombre;
    String apellido;

    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public boolean validar_cliente(Collection<Cliente> clientes){
        for (Cliente cliente : clientes) {
            if (this.dni == cliente.getDni()) {
                return true;
            }
        }
        return false;
    }

    public int getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
