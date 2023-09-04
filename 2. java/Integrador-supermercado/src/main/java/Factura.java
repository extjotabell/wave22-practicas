import java.util.ArrayList;
import java.util.Collection;

public class Factura {
    Cliente cliente;
    ArrayList<Item> items = new ArrayList<>();

    public Factura(Cliente cliente, ArrayList<Item> items) {
        this.cliente = cliente;
        this.items = items;
    }


}
