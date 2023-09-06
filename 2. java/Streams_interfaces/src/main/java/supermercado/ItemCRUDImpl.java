package supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ItemCRUDImpl implements InterfaceCRUD<Item>{

    List<Item> listaItems = new ArrayList<>();

    @Override
    public void alta(Item objeto) {
        listaItems.add(objeto);
    }

    @Override
    public void baja(Integer id) {
        int index = -1;
        for (int i=0; i<listaItems.size(); i++){
            if (Objects.equals(listaItems.get(i).getCodigo(), id)){
                index = i;
            }
        }
        if (index == -1) return;
        listaItems.remove(index);

    }

    @Override
    public void modificacion(Item objeto) {

        int index = -1;
        for (int i=0; i<listaItems.size(); i++){
            if (Objects.equals(listaItems.get(i).getCodigo(), objeto.getCodigo())){
                index = i;
            }
        }
        if (index == -1) return;

    }

    @Override
    public Optional<Item> consulta(Integer id) {
        return listaItems.stream().filter(item -> Objects.equals(item.getCodigo(), id)).findFirst();
    }

    @Override
    public List<Item> obtenerTodos() {
        return listaItems;
    }
}
