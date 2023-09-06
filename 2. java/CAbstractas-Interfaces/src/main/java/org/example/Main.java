package org.example;

import org.example.Ejercicio1.CashExtraction;
import org.example.Ejercicio1.CheckSavings;
import org.example.Ejercicio1.Clients.Basic;
import org.example.Ejercicio1.Clients.Client;
import org.example.Ejercicio1.Clients.Cobrador;
import org.example.Ejercicio1.Clients.Ejecutivo;
import org.example.Ejercicio1.Deposit;
import org.example.Ejercicio1.Transaction;
import org.example.Ejercicio2.Curriculum;
import org.example.Ejercicio2.Informe;
import org.example.Ejercicio2.LibroPdf;
import org.example.Ejercicio2.Persona;
import org.example.Ejercicio3.Animal;
import org.example.Ejercicio3.Gato;
import org.example.Ejercicio3.Perro;
import org.example.Ejercicio3.Vaca;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // EJERCICIO 1
        Client client1 = new Basic("magui", "1234", 2000);
        Transaction transaction1 = new CashExtraction(client1, 3000);
        Transaction transaction2 = new CashExtraction(client1, 1000);
        client1.makeTransaction(transaction1);
        client1.makeTransaction(transaction2);

        Client client2 = new Ejecutivo("carlos", "567", 1000000);
        Transaction transaction3 = new Deposit(10000, "1234");
        client2.makeTransaction(transaction3);
        client2.makeTransaction(transaction1);

        Client client3 = new Cobrador("pepito", "0001", 40000);
        Transaction transaction4 = new CheckSavings();
        client3.makeTransaction(transaction4);

        // EJERCICIO 2
        Persona persona = new Persona("jose");
        List<String> list = new ArrayList<>();
        Curriculum curriculum = new Curriculum(persona, list);
        curriculum.imprimir(curriculum);

        LibroPdf libro = new LibroPdf(100, "pedro", "un libro", "novela");
        libro.imprimir(libro);

        Informe informe = new Informe(100, 100, "pedro", "pepito");
        informe.imprimir(informe);

        // EJERCICIO 3
        Perro perro = new Perro();
        Vaca vaca = new Vaca();
        Gato gato = new Gato();

        perro.hablar();
        perro.comerCarne();
        vaca.hablar();
        vaca.comerHierba();
        gato.hablar();
        gato.comerCarne();


    }

}