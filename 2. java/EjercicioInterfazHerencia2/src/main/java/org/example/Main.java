package org.example;

import org.example.Clases.Curriculum;
import org.example.Clases.Informes;
import org.example.Clases.LibrosPDF;
import org.example.Interfaces.Imprimible;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<Imprimible> documentos = new ArrayList<>();

        Curriculum curriculum = new Curriculum("Enzo", "Coppeti", 27, "Pierna derecha, 9 de raza, temido por los defensores");
        LibrosPDF libro = new LibrosPDF(521,"Sebastian Beccacece","El futbol que me gusta", "Educacion");
        Informes informe = new Informes(10, 1, "Fernando Gago", "Ruben Capria");

        documentos.add(curriculum);
        documentos.add(libro);
        documentos.add(informe);

        ImprimirPilaaDeDocumentos(documentos);

        }

    public static void ImprimirPilaaDeDocumentos(List<Imprimible> pilaDeDocumentos){
        for (Imprimible documento : pilaDeDocumentos) {
            documento.imprimir();
        }
    }
    }

