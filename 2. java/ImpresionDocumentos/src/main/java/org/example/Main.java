package org.example;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Una persona","Una habilidad");
        LibroPDF libroPDF = new LibroPDF(100,"El autor","El Titulo","El Genero");
        Informe informe = new Informe("Texto",120,"El Autor","El Revisor");
        curriculum.imprimir();
        libroPDF.imprimir();
        informe.imprimir();
    }
}