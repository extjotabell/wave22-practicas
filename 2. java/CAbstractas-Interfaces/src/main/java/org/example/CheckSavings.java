package org.example;

import org.example.Clients.Client;

public class CheckSavings implements Transaction{


    @Override
    public void transactionOk() {
        System.out.println("Your balance is: ");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("You are not able to check your balance");
    }
}
