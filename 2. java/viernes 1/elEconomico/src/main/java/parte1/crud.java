package parte1;

import java.util.List;
import java.util.Optional;

public interface crud <T>{

    public void guardar(T obj);
    public void mostrar();
    public void eliminar(String id);
    public Optional<T> buscar(String id);
    public List<T> traerTodo();
}
