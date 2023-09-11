import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Inscripcion> inscripciones = new ArrayList<>();
        Categoria chico = new Categoria(1, "Circuito chico", "2 km.");
        Categoria mediano = new Categoria(2, "Circuito mediano", "5 km.");
        Categoria avanzado = new Categoria(3, "Circuito avanzado", "10 km.");

        Participante p1 = new Participante("Nahuel", 28);
        Participante p2 = new Participante("Juan", 15);
        Participante p3 = new Participante("Pedro", 16);

        inscripciones.add(new Inscripcion(0, chico, p1));
        inscripciones.add(new Inscripcion(1, mediano, p2));
        inscripciones.add(new Inscripcion(2, avanzado, p3));

        for (Inscripcion i : inscripciones) {
            System.out.println(i.participante.nombre + i.categoria.nombre + i.costo);
        }
    }
}
