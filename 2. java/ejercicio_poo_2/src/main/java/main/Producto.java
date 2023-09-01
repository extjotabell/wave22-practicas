package main;

public class Producto {

    protected String name;

    protected double prize;

    public Producto(String name, double prize) {
        this.name = name;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public double getPrize() {
        return prize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "name='" + name + '\'' +
                ", prize=" + prize +
                '}';
    }

    public double calcular(int quantityOfProducts){
        return quantityOfProducts * prize;
    }
}
