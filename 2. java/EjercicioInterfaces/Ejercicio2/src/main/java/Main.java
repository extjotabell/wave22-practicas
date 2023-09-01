import model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Imprimible documentoPdf = new PDF(2,new Autor());
        Imprimible curriculum = new Curriculum(new Persona(), List.of("correr","leer"));
        Imprimible informe = new Informe("texto inicial",20,new Autor(),new Persona());

        informe.imprimir();
        documentoPdf.imprimir();
        curriculum.imprimir();
    }
}
