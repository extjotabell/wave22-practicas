package documentos;

public class Main {
    public static void main(String[] args) {

        Curriculum curriculum = new Curriculum("Facundo", "Developer", "Ingeniería");
        LibroPDF pdf = new LibroPDF(150, "Pepe", "Título", "Tecnología");
        Informe informe = new Informe(70, "Facundo", "asbjebvkjrbskvjr", "Profesor");

        curriculum.imprimir(curriculum);
        pdf.imprimir(pdf);
        informe.imprimir(informe);

    }
}
