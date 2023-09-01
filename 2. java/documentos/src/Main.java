import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Matias Marin", "mati@marin.com");
        List<String> habilidades = Arrays.asList("Java", "Javascript", "Mongo");
        Curriculum curriculum = new Curriculum(persona, habilidades);

        LibroPDF libro = new LibroPDF(200, "Yo", "Títulazo", "Terror");

        Informe informe = new Informe("Contenido que puede tener el texto", 10, "Yo", "Profe");

        Impresora.imprimir(curriculum);
        Impresora.imprimir(libro);
        Impresora.imprimir(informe);
    }
}