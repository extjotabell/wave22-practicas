package org.example.Ejercicio1.Clients;

import org.example.Ejercicio1.CashExtraction;
import org.example.Ejercicio1.CheckSavings;
import org.example.Ejercicio1.Transaction;

public class Cobrador extends Client{
    public Cobrador(String name, String account, double balance) {
        super(name, account, balance);
    }

    @Override
    public void makeTransaction(Transaction t) {
        boolean isAble = t.getClass().equals(CheckSavings.class) || t.getClass().equals(CashExtraction.class);
        if(!isAble){
            t.transactionNotOk();
        }
        t.transactionOk();
    }
}
