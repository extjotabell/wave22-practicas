package Ejercicio2;

public class Main {
    public static void main(String[] args) {
        String habilidades[] = {"Analitica", "Proactiva", "Liderazgo"};
        Imprimible<Curriculums> curriculum = new Curriculums("Cecilia","32", "Developer", habilidades);
        Imprimible<Libro> libro = new Libro(10,"J.F. Tool", "La conjura de los necios","Novela");
        Imprimible<Informes> informe = new Informes("Esto es un texto", 20, "Este es un autor", "Este es el revisor");

        curriculum.imprimir();
        libro.imprimir();
        informe.imprimir();
    }
}
