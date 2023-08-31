package org.example;

public class Perecedero extends Producto{

    private Integer diasPorCaducar;
    public Perecedero(String nombre, double precio, Integer diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public Integer getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(Integer diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    private void ajustarPrecio(){
        if (this.diasPorCaducar <=1 ){
            setPrecio(getPrecio()/4);
        } else if (this.diasPorCaducar <=2) {
            setPrecio(getPrecio()/3);
        } else if (this.diasPorCaducar <=3) {
            setPrecio(getPrecio()/2);
        }
    }
    @Override
    public double calcular(Integer cantidadDeProductos) {
        ajustarPrecio();
        return super.calcular(cantidadDeProductos);
    }
}
