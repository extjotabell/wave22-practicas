package supermercado;

import java.util.List;
import java.util.Map;

public interface FacturaCRUD {
    void alta(Factura factura, Map<Integer, Factura> listaFacturas, List<Cliente> listaClientes, List<Item> listaItems);

    void baja(Map<Integer, Factura> listaFacturas, Integer id);

    void modificacion(Map<Integer, Factura> listaFacturas, Factura factura);

    Factura consulta(Map<Integer, Factura> listaFacturas, Integer id);
}
