package org.example;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String name, double price, int diasPorCaducar) {
        super(name, price);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "name='" + super.getName() + '\'' +
                ", price=" + super.getPrice() +
                ", diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calculate(int amount) {
        switch (this.diasPorCaducar){
            case 1:
                return (amount*super.getPrice())/4;
            case 2:
                return (amount*super.getPrice())/3;
            case 3:
                return (amount*super.getPrice())/2;
        }
        return super.calculate(amount);
    }
}
