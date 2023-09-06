package org.example.Ejercicio1;

import org.example.Ejercicio1.Clients.Client;

public class Deposit implements Transaction {

    private Client emisor;
    private double amount;
    private String recipient;

    public Deposit(double amount, String recipient) {
        this.amount = amount;
        this.recipient = recipient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }


    @Override
    public void transactionOk() {
        System.out.println("Money deposited");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("You are unable to perform a deposit");
    }
}
