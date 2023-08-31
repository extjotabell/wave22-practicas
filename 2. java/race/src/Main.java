import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Categoria circuitoChico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");


        Participante participante1 = new Participante(1, 12345678, "Lionel", "Messi", 20, "1234567890", "987654321", "A+");
        Participante participante2 = new Participante(2, 23456789, "Emiliano", "Martinez", 17, "0987654321", "876543219", "AB+");
        Participante participante3 = new Participante(3, 435345, "Ruben", "Insua", 40, "1234567890", "987654321", "A+");
        Participante participante4 = new Participante(4, 12345678, "Agustin", "Giay", 17, "1234567890", "987654321", "A+");

        Inscripcion inscripcion1 = new Inscripcion(1, circuitoChico, participante1);
        Inscripcion inscripcion2 = new Inscripcion(2, circuitoMedio, participante2);
        Inscripcion inscripcion3 = new Inscripcion(2, circuitoMedio, participante3);
        Inscripcion inscripcion4 = new Inscripcion(2, circuitoAvanzado, participante4);

        List<Inscripcion> inscripciones = new ArrayList<>();
        inscripciones.add(inscripcion1);
        inscripciones.add(inscripcion2);
        inscripciones.add(inscripcion3);
        inscripciones.add(inscripcion4);

        mostrarInscriptosPorCategoria(inscripciones, circuitoChico);
        mostrarInscriptosPorCategoria(inscripciones, circuitoAvanzado);
        mostrarInscriptosPorCategoria(inscripciones, circuitoMedio);

        inscripciones.remove(inscripcion1);

        System.out.println("-----------------ELIMINAR PARTICIPANTE-----------------");

        mostrarInscriptosPorCategoria(inscripciones, circuitoChico);
        mostrarInscriptosPorCategoria(inscripciones, circuitoAvanzado);
        mostrarInscriptosPorCategoria(inscripciones, circuitoMedio);

        calcularMontosTotales(inscripciones);
    }

    private static void mostrarInscriptosPorCategoria(List<Inscripcion> inscripciones, Categoria categoria) {
        System.out.println("Inscriptos en la categoría: " + categoria.nombre );
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.categoria == categoria) {
                System.out.println("Participante: " + inscripcion.participante.nombre + " " + inscripcion.participante.apellido + " " + inscripcion.participante.celular + " " + inscripcion.participante.dni + "Número de inscripción: " + inscripcion.numeroInscripcion);
            }
        }
    }

    private static void calcularMontosTotales(List<Inscripcion> inscripciones) {
        double totalCircuitoChico = 0;
        double totalCircuitoMedio = 0;
        double totalCircuitoAvanzado = 0;

        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.categoria.nombre.equals("Circuito chico")) {
                totalCircuitoChico += inscripcion.monto;
            } else if (inscripcion.categoria.nombre.equals("Circuito medio")) {
                totalCircuitoMedio += inscripcion.monto;
            } else if (inscripcion.categoria.nombre.equals("Circuito avanzado")) {
                totalCircuitoAvanzado += inscripcion.monto;
            }
        }

        double totalCarrera = totalCircuitoChico + totalCircuitoMedio + totalCircuitoAvanzado;

        System.out.println("Total recaudado en Circuito chico: $" + totalCircuitoChico);
        System.out.println("Total recaudado en Circuito medio: $" + totalCircuitoMedio);
        System.out.println("Total recaudado en Circuito avanzado: $" + totalCircuitoAvanzado);
        System.out.println("Total recaudado en toda la carrera: $" + totalCarrera);
    }
}
