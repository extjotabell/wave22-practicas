package org.example.Models;

public class Item {
    private int cod;
    private String name;
    private int quantity;
    private double unit_cost;

    public Item() {
    }

    public Item(int cod, String name, int quantity, double unit_cost) {
        this.cod = cod;
        this.name = name;
        this.quantity = quantity;
        this.unit_cost = unit_cost;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnit_cost() {
        return unit_cost;
    }

    public void setUnit_cost(double unit_cost) {
        this.unit_cost = unit_cost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "cod=" + cod +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unit_cost=" + unit_cost +
                '}';
    }
}
