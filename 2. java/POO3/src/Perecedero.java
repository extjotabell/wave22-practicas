public class Perecedero extends Producto {
    int diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, double precio) {
        super(nombre, precio);
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
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double precioTotal = super.calcular(cantidadDeProductos);
        if (diasPorCaducar == 1) {
            precioTotal *= 0.25;
        } else if (diasPorCaducar == 2) {
            precioTotal *=  0.3;
        } else if (diasPorCaducar == 3) {
            precioTotal *= 0.5;
        }
        return precioTotal;
    }
}
