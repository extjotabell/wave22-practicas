package org.example;

import org.example.Clients.Basic;
import org.example.Clients.Client;
import org.example.Clients.Cobrador;
import org.example.Clients.Ejecutivo;

public class Main {
    public static void main(String[] args) {

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
    }
}