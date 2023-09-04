package org.salvonicolas;

public class Item {
    private int code;
    private String name;
    private double unitPrice;

    public Item(int code, String name, double unitPrice) {
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "["+ code + "]" + " - " + name + " $" + unitPrice;
    }
}
