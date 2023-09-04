package org.salvonicolas;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository implements CRUD<Invoice>{
    private final List<Invoice> invoices;

    public InvoiceRepository() {
        invoices = new ArrayList<>();
    }

    @Override
    public void remove(Invoice element) {
        invoices.remove(element);
    }

    @Override
    public void add(Invoice element) {
        invoices.add(element);
    }

    @Override
    public List<Invoice> getAll() {
        return invoices;
    }

    @Override
    public Invoice get(int index) {
        return invoices.get(index);
    }

    @Override
    public void print() {
        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }
}
