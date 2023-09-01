package main;

public class NoPerecedero extends Producto{
    private String type;

    public NoPerecedero(String name, double prize, String type) {
        super(name, prize);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "type='" + type + '\'' +
                '}';
    }


}
