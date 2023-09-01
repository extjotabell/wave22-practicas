package main;

public class Perecedero extends Producto{
    int daysToExpire;

    public Perecedero(String name, double prize, int daysToExpire) {
        super(name, prize);
        this.daysToExpire = daysToExpire;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "daysToExpire=" + daysToExpire +
                '}';
    }

    @Override
    public double calcular(int quantityOfProducts){
        double rtn = 0;
        switch (daysToExpire){
            case 1: rtn = (quantityOfProducts * prize)/4;
            break;
            case 2: rtn = (quantityOfProducts * prize)/3;
            break;
            case 3: rtn = (quantityOfProducts * prize)/2;
            break;
        }
        return rtn;
    }
}
