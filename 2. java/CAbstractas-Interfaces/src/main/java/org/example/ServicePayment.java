package org.example;

public class ServicePayment implements Transaction{
    @Override
    public void transactionOk() {
        System.out.println("Service payed successfully");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("You are not able to make service payments");
    }
}
