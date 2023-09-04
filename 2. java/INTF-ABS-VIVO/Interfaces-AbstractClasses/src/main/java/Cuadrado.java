public class Cuadrado extends FiguraGeometrica{
    private double longitudLado;

    @Override
    public double calcularArea() {
        return longitudLado * longitudLado;
    }

    public Cuadrado(double longitudLado) {
        this.longitudLado = longitudLado;
    }

}
