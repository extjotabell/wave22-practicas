public class Circulo extends FiguraGeometrica {
    private final double radio;

    @Override
    public double calcularArea() {
        return Math.PI * (radio * radio);
    }

    public Circulo(double radio) {
        this.radio = radio;
    }
}
