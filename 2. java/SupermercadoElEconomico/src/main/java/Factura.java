import java.util.List;

public class Factura {
    Cliente cliente;
    List<Producto> items;
    double total;

    public List<Producto> getItems() {
        return items;
    }
    public void setItems(List<Producto> items) {
        this.items = items;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }
    public void calcularTotal(){
        Double total = items.stream().mapToDouble(Producto::getCosto).sum();
    }
}
