package org.example.Clients;

import org.example.CashExtraction;
import org.example.CheckSavings;
import org.example.ServicePayment;
import org.example.Transaction;

public class Basic extends Client{
    public Basic(String name, String account, double balance) {
        super(name, account, balance);
    }

    @Override
    public void makeTransaction(Transaction t) {
        boolean isAble = t.getClass().equals(CheckSavings.class) || t.getClass().equals(ServicePayment.class) || t.getClass().equals(CashExtraction.class);
        if(!isAble){
            t.transactionNotOk();
        }
        t.transactionOk();
    }
}
