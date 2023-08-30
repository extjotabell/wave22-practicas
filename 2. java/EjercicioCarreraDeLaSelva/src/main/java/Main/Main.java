package Main;

public class Main {

    public static void main(String[] args) {
        Categoria chico = new Categoria(1, "Circuito Chico", "selva y arroyos", 2);
        Categoria medio = new Categoria(2, "Circuito Medio", "selva, arroyos y barro", 5);
        Categoria avanzado = new Categoria(3, "Circuito Avanzado", "selva, arroyos, barro y escalada en piedra", 10);

        Participante p1 = new Participante(1, "1234", "Javier", "Gomez", 23, "123", "123", "A+");
        Participante p2 = new Participante(2, "1234", "Matias", "Fernandez", 16, "123", "123", "A+");
        Participante p3 = new Participante(3, "1234", "Gaston", "Ezeiza", 21, "123", "123", "A+");
        Participante p4 = new Participante(4, "1234", "Camila", "Gonzalez", 19, "123", "123", "A+");

        chico.inscribirParticipante(p1);
        medio.inscribirParticipante(p2);
        avanzado.inscribirParticipante(p3);
        chico.inscribirParticipante(p4);
        chico.inscribirParticipante(p1);

        chico.mostrarParticipantes();
        medio.mostrarParticipantes();
        avanzado.mostrarParticipantes();

        chico.desincribirParticipante(p4);
        chico.mostrarParticipantes();

        System.out.println(chico.getNombre());
        System.out.println("Recaudacion: " +chico.calcularRecaudacion());
        System.out.println(medio.getNombre());
        System.out.println("Recaudacion: " +medio.calcularRecaudacion());
        System.out.println(avanzado.getNombre());
        System.out.println("Recaudacion: " +avanzado.calcularRecaudacion());

    }
}
