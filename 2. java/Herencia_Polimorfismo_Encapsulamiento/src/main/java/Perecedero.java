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
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double precioBase = super.calcular(cantidadDeProductos);
        if(precioBase >= 3){
            return precioBase / 2 ;
        }
        else if(precioBase == 2){
            return precioBase / 3;
        }
        else if (precioBase == 1) {
            return precioBase / 4;
        }
        return 0.0;
    }
}
