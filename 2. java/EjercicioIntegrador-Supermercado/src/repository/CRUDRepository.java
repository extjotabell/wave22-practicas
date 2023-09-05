package repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository <T>{

    public void save(T objecto);
    public void mostrarPantalla();
    public Optional<T> findById(String id);
    public void delete(String id);
    public List<T> traerTodos();
}
