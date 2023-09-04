package org.example;

import org.example.Banco.Clases.Basic;
import org.example.Documentos.Clases.Documento;
import org.example.Documentos.Clases.LibroPDF;
import org.example.Zoologico.Clases.Animal;
import org.example.Zoologico.Clases.Gato;
import org.example.Zoologico.Clases.Perro;
import org.example.Zoologico.Clases.Vaca;

public class Main {
    public static void main(String[] args) {


        //ejemplo EJERCICIO 1 - Banco

        Basic nuevoBasic = new Basic();

        int resultadoOperacion = nuevoBasic.RealizarConsultaDeSaldo();

        if (resultadoOperacion == 1){
            nuevoBasic.TransaccionOk("Consulta de saldo");
        } else {
            nuevoBasic.TransaccionNoOk("Consulta de saldo");
        }

        System.out.println("--------------------------------------------------------------------------------");

        //ejemplo EJERCICIO 2 - Documentos

        LibroPDF doc = new LibroPDF(50, "Borges", "El Mejor libro PDF", "APT");

        System.out.println(doc.imprimir(doc.getTitulo()));

        System.out.println("--------------------------------------------------------------------------------");

        //ejemplo EJERCICIO 3 - Zoologico

        Perro nuevoPerro = new Perro();

        nuevoPerro.EmitirSonido();
        nuevoPerro.ComiendoCarne();

        Vaca nuevaVaca = new Vaca();

        nuevaVaca.EmitirSonido();
        nuevaVaca.ComiendoHierba();

        Gato nuevoGato = new Gato();

        nuevoGato.EmitirSonido();
        nuevoGato.ComiendoCarne();

    }
}