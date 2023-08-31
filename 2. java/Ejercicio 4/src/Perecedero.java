public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
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

    private void ajustarPrecio(){
        double factorDescuento = 1.0;

        if (this.diasPorCaducar <= 1) {
            factorDescuento = 0.25;
        } else if (this.diasPorCaducar <= 2) {
            factorDescuento = 0.33;
        } else if (this.diasPorCaducar <= 3) {
            factorDescuento = 0.5;
        }

        setPrecio(getPrecio() * factorDescuento);
    }
    @Override
    public double calcular(int cantidadDeProductos){
        ajustarPrecio();
        return super.calcular(cantidadDeProductos);
    }
}
