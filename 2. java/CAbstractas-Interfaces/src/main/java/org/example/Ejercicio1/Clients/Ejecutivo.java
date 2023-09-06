package org.example.Ejercicio1.Clients;

import org.example.Ejercicio1.Deposit;
import org.example.Ejercicio1.Transaction;
import org.example.Ejercicio1.Transference;

public class Ejecutivo extends Client{

    public Ejecutivo(String name, String account, double balance) {
        super(name, account, balance);

    }

    @Override
    public void makeTransaction(Transaction t) {
        boolean isAble = t.getClass().equals(Deposit.class) || t.getClass().equals(Transference.class);
        if(!isAble){
            t.transactionNotOk();
        }
        t.transactionOk();
    }
}
