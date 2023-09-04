package org.example.Models;

import java.util.List;

public class Bill {
    private Client clientBill;
    private List<Item> itemList;
    private double amount;

    public Bill() {
    }

    public Bill(Client clientBill, List<Item> itemList, double amount) {
        this.clientBill = clientBill;
        this.itemList = itemList;
        this.amount = amount;
    }

    public Client getClientBill() {
        return clientBill;
    }

    public void setClientBill(Client clientBill) {
        this.clientBill = clientBill;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "clientBill=" + clientBill +
                ", itemList=" + itemList +
                ", amount=" + amount +
                '}';
    }
}
