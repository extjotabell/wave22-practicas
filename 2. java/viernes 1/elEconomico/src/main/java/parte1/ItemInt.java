package parte1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ItemInt implements crud<Item>{

    ArrayList<Item> items = new ArrayList<>();
    @Override
    public void guardar(Item obj) {
        items.add(obj);
    }

    @Override
    public void mostrar() {
        for(Item it : items){
            System.out.printf(it.toString());
        }
    }

    @Override
    public void eliminar(String id) {

        Optional<Item> it =  this.buscar(id);

        if(it.isEmpty()){
            System.out.printf("No se encontro el item");
        }else{
            items.remove(it.get());
        }
    }

    @Override
    public Optional<Item> buscar(String id) {


        boolean band= true;

        for (Item it : items){
            if(Objects.equals(it.getCodigo(),id)){
                System.out.printf(it.toString());
                return Optional.of(it);
            }else{
                System.out.printf("No se encontro el item");
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Item> traerTodo() {
        return items;
    }
}
