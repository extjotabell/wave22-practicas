import java.util.List;

public class Factura {

    private double montoTotalCompra;
    private Cliente comprador;
    private List<Item> itemsComprados;

    public Factura(double montoTotalCompra, Cliente comprador, List<Item> itemsComprados) {
        this.montoTotalCompra = montoTotalCompra;
        this.comprador = comprador;
        this.itemsComprados = itemsComprados;
    }
}
