import java.util.ArrayList;

public class Curriculum extends Documento{

    private String nombre;
    private String email;
    private ArrayList<String> habilidades;

    public Curriculum(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.habilidades = new ArrayList<>();;
    }

    public void agregarHabilidad(String habilidad){
        habilidades.add(habilidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public void imprimir() {
        imprimirTipoDoc();
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        for (String habilidad: habilidades) {
            System.out.println("Habilidad: " + habilidad);
        }
    }
}
