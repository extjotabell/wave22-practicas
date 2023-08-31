public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

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
    public double calcular(int cantidadDeProductos) {

        switch (this.diasPorCaducar){
            case 1:
                return (super.getPrecio() * cantidadDeProductos )  / 4;
            case 2:
                return (super.getPrecio() * cantidadDeProductos )  / 3;
            case 3:
                return (super.getPrecio() * cantidadDeProductos )  / 2;
            default:
                return super.getPrecio() * cantidadDeProductos;

        }
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
