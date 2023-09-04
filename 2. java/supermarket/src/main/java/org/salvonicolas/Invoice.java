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
    public void addItem(Item item, int quantity) {
        itemLines.add(new ItemLine(item, quantity));
    }

    public double calculateTotal() {
         return itemLines.stream().mapToDouble(ItemLine::getTotal).sum();
    }

    public void printTotal() {
        System.out.println("El total de la factura es: " + calculateTotal());
    }

    @Override
    public String toString() {
        String stringBuilder = "";
        for (ItemLine line: itemLines) {
            stringBuilder += line.toString() + "\n";
        }
        stringBuilder += "El total de la factura es: $" + calculateTotal();
        return stringBuilder;
    }
}
