package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Java");
        habilidades.add("Python");

        Curriculum curriculum = new Curriculum("Alejandro", "Hetman",
                                                "43561328", 21, habilidades );

        curriculum.agregarHabilidad("Swift");
        Imprimible.imprimirDocumento(curriculum);

        System.out.println();

        Informe informe = new Informe("Informe acerca Taylor Swift", 13,
                                    "Alejandro Hetman", "Taylor Swift");

        Imprimible.imprimirDocumento(informe);

        System.out.println();

        LibroPDF libroPDF = new LibroPDF("Comedia Romántica", 1321,
                                        "Leonardo Di Caprio", "How I met your mother");

        Imprimible.imprimirDocumento(libroPDF);
    }
}