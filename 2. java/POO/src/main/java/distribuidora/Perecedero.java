package distribuidora;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadProductos){
        double descuento = 1;
        if(this.diasPorCaducar == 1){
            descuento = 4;
        }else if(this.diasPorCaducar == 2){
            descuento = 3;
        }else if(this.diasPorCaducar == 3){
            descuento = 2;
        }
        return (cantidadProductos * getPrecio())/descuento;
    }
}
