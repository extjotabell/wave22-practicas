package org.salvonicolas;

public class ItemLine {
    private Item item;
    private int quantity;
    private double total;
    public ItemLine(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        total = this.item.getUnitPrice() * quantity;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return item.toString() + " x" + quantity + "u = $" + total;
    }
}
