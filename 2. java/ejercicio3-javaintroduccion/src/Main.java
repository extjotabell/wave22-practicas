import domain.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Competencia competencia1 = new Competencia();

        Categoria circuitoChico = new Categoria(TipoCategoria.CIRCUITO_CHICO, "2 km por selva y arroyos.");
        Categoria circuitoMedio = new Categoria(TipoCategoria.CIRCUITO_MEDIO, "5 km por selva, arroyos y barro.");
        Categoria circuitoAvanzado = new Categoria(TipoCategoria.CIRCUITO_AVANZADO, "10 km por selva, arroyos, barro y escalada en piedra.");


        Participante participanteJulio = new Participante(1, "42804438", "Julio",
                "Alvarez", 22, "1150054130", "1144873489","ABC");

        Participante participanteFabricio = new Participante(1, "24335630", "Fabricio",
                "Romano", 34, "1145235678", "1144873489","DFF");

        Participante participantePablo = new Participante(1, "3455678", "Pablo",
                    "Cid", 52, "114235410", "1144873489","DRX");

        Participante participanteJoaquin = new Participante(1, "2345567", "Joaquin",
                "Benavidez", 24, "114256378", "1144873489","SSZ");


        Inscripcion inscripcion1 = new Inscripcion(participanteJulio, circuitoChico);
        Inscripcion inscripcion2 = new Inscripcion(participantePablo, circuitoMedio);
        Inscripcion inscripcion3 = new Inscripcion(participanteJoaquin, circuitoAvanzado);
        Inscripcion inscripcion4 = new Inscripcion(participanteFabricio, circuitoChico);

        competencia1.inscribirCompetencia(inscripcion1);
        competencia1.inscribirCompetencia(inscripcion2);
        competencia1.inscribirCompetencia(inscripcion3);
        competencia1.inscribirCompetencia(inscripcion4);


        System.out.println(inscripcion1.getAbonoParticipante());
        System.out.println(inscripcion2.getAbonoParticipante());
        System.out.println(inscripcion3.getAbonoParticipante());

        competencia1.getInscripcionesCategoria(circuitoChico);
        System.out.println("------------- Eliminando participante Fabricio --------------");
        competencia1.removeInscripcion(inscripcion4.getId());
    }
}