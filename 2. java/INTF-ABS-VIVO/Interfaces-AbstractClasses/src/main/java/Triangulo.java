public class Triangulo extends FiguraGeometrica {

    private double base;
    private double altura;

    @Override
    public double calcularArea() {
        return base * altura / 2;
    }

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
}
