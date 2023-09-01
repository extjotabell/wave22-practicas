public class Vehicle {
    private String model;
    private String brand;
    private double cost;

    public Vehicle(String model, String brand, int cost) {
        this.model = model;
        this.brand = brand;
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "\n Vehicle{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", cost=" + cost +
                '}';
    }
}