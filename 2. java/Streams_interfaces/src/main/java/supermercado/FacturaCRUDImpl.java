package supermercado;

import java.util.*;

public class FacturaCRUDImpl implements InterfaceCRUD<Factura> {

    List<Factura> listaFacturas = new ArrayList<>();

    @Override
    public void alta(Factura objeto) {
        listaFacturas.add(objeto);
    }

    @Override
    public void baja(Integer id) {
        int index = -1;
        for (int i=0; i<listaFacturas.size(); i++){
            if(Objects.equals(listaFacturas.get(i).getId(), id)){
                index = i;
            }
        }
        if (index == -1) return;
        listaFacturas.remove(index);
    }

    @Override
    public void modificacion(Factura objeto) {
        int index = -1;
        for (int i=0; i<listaFacturas.size(); i++){
            if(Objects.equals(listaFacturas.get(i).getId(), objeto.getId())){
                index = i;
            }
        }
        if (index == -1) return;
        listaFacturas.set(index, objeto);
    }

    @Override
    public Optional<Factura> consulta(Integer id) {
        return listaFacturas.stream().filter(factura -> Objects.equals(factura.getId(), id)).findFirst();
    }

    @Override
    public List<Factura> obtenerTodos() {
        return listaFacturas;
    }
}
