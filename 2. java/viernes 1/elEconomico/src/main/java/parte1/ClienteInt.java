package parte1;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.List;

public class ClienteInt implements crud<Cliente> {

    ArrayList<Cliente> listaClientes = new ArrayList<>();

    @Override
    public void guardar(Cliente obj) {
        listaClientes.add(obj);
    }

    @Override
    public void mostrar() {

        for (Cliente cli: listaClientes) {
            System.out.printf(cli.toString());
        }
    }

    @Override
    public void eliminar(String id) {

        Optional<Cliente> cli = this.buscar(id);

        if(cli.isEmpty()){
            System.out.printf("El cliente no fue encontrado");
        }else{
            this.listaClientes.remove(cli.get());
            System.out.printf("El cliente fue borrado");
        }
    }

    @Override
    public Optional<Cliente> buscar(String id) {

        boolean band= true;

        for (Cliente cli: listaClientes){
            if (Objects.equals(cli.getDni(),id)) {
                System.out.printf(cli.toString());
                band=false;
                return Optional.of(cli);
            }if(band){
                System.out.print("No se encontro el cliente");
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Cliente> traerTodo() {
        return listaClientes;
    }


}
