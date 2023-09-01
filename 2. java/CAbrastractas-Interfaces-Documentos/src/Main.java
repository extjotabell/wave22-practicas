
public class Main {
    public static void main(String[] args) {

        LibrosPDF libro = new LibrosPDF(800,"Carlos Castaneda", "Las enseñanzas de Don Juan", "Memorias");
        Curriculum curriculum = new Curriculum("Jose Francisco","San Martin");
        Informe informe = new Informe("Lorem ipsum sit amet",4,"Carlos Sanchez","Omar Rodriguez");

        curriculum.agregarHabilidad("Liberar Paises");
        curriculum.agregarHabilidad("Tactica y Estrategia");
        curriculum.agregarHabilidad("Heroe Nacional");

        Imprimible.imprimirDocumento(curriculum);
        Imprimible.imprimirDocumento(libro);
        Imprimible.imprimirDocumento(informe);
    }
}