import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Persona pepito = new Persona("Pepito", "Doe", 123, 90);

        ArrayList<String> habilidadesDePepito = new ArrayList<>();

        habilidadesDePepito.add("Programar");

        Curriculum cv = new Curriculum(1, pepito, habilidadesDePepito);
        LibroPDF libro = new LibroPDF("JK Rowling", 1000, "Harry Potter", "Fantasia");
        Informe tesis = new Informe(100, 100 * 1000, "Pepito", "JK Rowling");

        cv.imprimir();
        libro.imprimir();
        tesis.imprimir();

    }

}
