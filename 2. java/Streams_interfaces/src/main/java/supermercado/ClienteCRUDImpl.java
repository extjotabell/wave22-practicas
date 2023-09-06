package supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ClienteCRUDImpl implements InterfaceCRUD<Cliente>{

    List<Cliente> listaClientes = new ArrayList<>();
    @Override
    public void alta(Cliente objeto) {
        listaClientes.add(objeto);
    }

    @Override
    public void baja(Integer id) {
        int index = -1;
        for (int i=0; i<listaClientes.size(); i++){
            if(Objects.equals(listaClientes.get(i).getDni(), id.toString())){
                index = i;
            }
        }
        if (index == -1) return;
        listaClientes.remove(index);
    }

    @Override
    public void modificacion(Cliente objeto) {
        int index = -1;
        for (int i=0; i<listaClientes.size(); i++){
            if(Objects.equals(listaClientes.get(i).getDni(), objeto.getDni())){
                index = i;
            }
        }
        if (index == -1) return;
    }

    @Override
    public Optional<Cliente> consulta(Integer id) {
        return listaClientes.stream().filter(cliente -> cliente.getDni().equals(id.toString())).findFirst();
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return listaClientes;
    }
}
