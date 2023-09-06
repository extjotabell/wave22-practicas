package org.example.Ejercicio1;

import org.example.Ejercicio1.Clients.Client;

public class CashExtraction implements Transaction{
    private Client extractor;

    private double amount;

    public CashExtraction(Client extractor, double amount) {
        this.extractor = extractor;
        this.amount = amount;
    }

    public Client getExtractor() {
        return extractor;
    }

    public void setExtractor(Client extractor) {
        this.extractor = extractor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public void transactionOk(){
        if(amount > extractor.getBalance())
            System.out.println("Not enough money in your account");
        else
            System.out.println("Money extraction completed");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("You are not able to perform an extraction");
    }

}
