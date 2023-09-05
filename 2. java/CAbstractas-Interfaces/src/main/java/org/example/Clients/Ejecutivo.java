package org.example.Clients;

import org.example.*;

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
