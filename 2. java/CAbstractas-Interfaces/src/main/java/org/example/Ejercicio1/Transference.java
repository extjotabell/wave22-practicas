package org.example.Ejercicio1;

import org.example.Ejercicio1.Clients.Client;

public class Transference implements Transaction{

    private Client from;
    private String recipient;
    private double amount;

    @Override
    public void transactionOk() {
        System.out.println("Money was transferred");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Unable to perform the transaction");
    }

}
