package org.example.Clients;

import org.example.Transaction;

public abstract class Client {
    private String name;
    private String account;
    private double balance;

    public Client(String name, String account, double balance) {
        this.name = name;
        this.account = account;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void makeTransaction(Transaction t);
}
