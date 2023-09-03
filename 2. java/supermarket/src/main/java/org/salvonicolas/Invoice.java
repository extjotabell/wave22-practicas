package org.salvonicolas;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private Customer customer;
    private List<ItemLine> itemLines;

    public Invoice(Customer customer) {
        this.customer = customer;
        itemLines = new ArrayList<>();
    }
}
