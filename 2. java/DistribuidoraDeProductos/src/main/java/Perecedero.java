public class Perecedero extends Producto{
    int diasParaCaducar;
    public int getDiasParaCaducar() {
        return diasParaCaducar;
    }
    public void setDiasParaCaducar(int diasParaCaducar) {
        this.diasParaCaducar = diasParaCaducar;
    }
    public Perecedero(String nombre, double precio, int diasParaCaducar) {
        super(nombre,precio);
        this.diasParaCaducar = diasParaCaducar;
    }
    @Override
    public String toString() {
        return "Perecedero{" +
                "diasParaCaducar=" + diasParaCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
    @Override
    double calcular(int cantidad){
        double total = cantidad*precio;
        if(diasParaCaducar == 1){
            return total/4;
        }
        else if(diasParaCaducar == 2) {
            return total / 3;
        }
        else if(diasParaCaducar == 3){
            return total/2;
        }
        return total;
    }
}
