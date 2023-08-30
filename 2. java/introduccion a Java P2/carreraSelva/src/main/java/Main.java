import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Inscripcion> inscripciones = new ArrayList<>();
        //a)
        Categoria circuitoChico = new Categoria(1, "circuitoChico","2 km por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "circuitoMedio","5 km por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "circuitoAvanzado","10 km por selva, arroyos, barro y escalada en piedra.");

        //b)
        Participante randy = new Participante(1,951323,"randy","mendoza",20,123123,31232,"A");
        Participante camila = new Participante(2,4234,"camila","soledad",24,534543,567567,"A");
        Participante nicolas = new Participante(3,73773,"nicolas","gug",17,978987,57567987,"A");
        Participante martin = new Participante(4,73773,"martin","johanna",18,5115,78687,"A");

        inscribirACategoria(inscripciones, randy, circuitoChico);

        //c)
        inscribirACategoria(inscripciones, camila, circuitoAvanzado);
        // con nicolas en avanzado tenemos error porque es menor de edad y no lo agrega a esa categoria
        inscribirACategoria(inscripciones, nicolas, circuitoAvanzado);
        inscribirACategoria(inscripciones, martin, circuitoAvanzado);


        //d)
        mostrarInscripciones(inscripciones, circuitoAvanzado.getNombre());
        //e) sacamos a martin
        desinscribirParticipante(inscripciones, martin);
        mostrarInscripciones(inscripciones, circuitoAvanzado.getNombre());

        //f)
        int montoCategoriaChico = montoPorCategoria("circuitoChico",inscripciones);
        int montoCategoriaMedio = montoPorCategoria("circuitoMedio",inscripciones);
        int montoCategoriaAvanzado = montoPorCategoria("circuitoAvanzado",inscripciones);
        int totalCarrera = montoCategoriaAvanzado + montoCategoriaChico + montoCategoriaMedio;
        System.out.println();
        System.out.println("Monto de categoria Circuito Chico: " + montoCategoriaChico);
        System.out.println("Monto de Categoria Circuito Medio: " + montoCategoriaMedio);
        System.out.println("Monto de Categoria Circuito Avanzado: " + montoCategoriaAvanzado);
        System.out.println("Total de todas las carreras: " + totalCarrera);


    }
    private static void inscribirACategoria(List<Inscripcion> inscripciones, Participante participante, Categoria categoria){
        Map<Integer, Participante> participantes = categoria.getParticipantes();
        if(estaInscriptoEnAlgunaCategoria(inscripciones, participante.getNumeroParticipante())){
            System.out.println("El participante ya se encuentra inscripto en una Categoria");
            return;
        }

        try{
            var inscripcion = new Inscripcion(inscripciones.size() + 1, categoria, participante);
            inscripciones.add(inscripcion);
            participantes.put(participante.getNumeroParticipante(), participante);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }

    private static boolean estaInscriptoEnAlgunaCategoria(List<Inscripcion> inscripciones, int numeroParticipante){
        for(Inscripcion inscripcion: inscripciones){
            if(inscripcion.getCategoria().getParticipantes().containsKey(numeroParticipante)){
                return true;
            }
        }
        return false;
    }

    private static void mostrarInscripciones(List<Inscripcion> inscripciones, String nombreCategoria){
        System.out.printf("Categoria: %s%n", nombreCategoria);
        for(Inscripcion inscripcion : inscripciones){
            if(inscripcion.getCategoria().getNombre().equals(nombreCategoria)){
                System.out.println("Numero de inscripcion: " + inscripcion.getNumeroInscripcion());
                System.out.println(inscripcion.getParticipante());
            };
        }
    }

    private static void desinscribirParticipante(List<Inscripcion> inscripciones, Participante participante){
        Inscripcion inscripcionAEliminar = null;
        for(Inscripcion inscripcion : inscripciones){
            if(inscripcion.getParticipante().equals(participante)){
                inscripcionAEliminar = inscripcion;
                inscripcion.getCategoria().getParticipantes().remove(participante.getNumeroParticipante());
                break;
            }
        }
        if(inscripcionAEliminar != null)
            inscripciones.remove(inscripcionAEliminar);
    }

    private static int montoPorCategoria(String nombreCategoria, List<Inscripcion> inscripciones){
        int total = 0;
        for(Inscripcion inscripcion : inscripciones){
            if(inscripcion.getCategoria().getNombre().equals(nombreCategoria)){
                total += inscripcion.getMontoAbonar();
            };
        }
        return total;
    }
}
