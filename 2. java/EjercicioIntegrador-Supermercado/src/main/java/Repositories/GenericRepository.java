package Repositories;

import java.util.List;

public interface GenericRepository<T> {
    abstract void agregar(List<T> lista, T entity);
    void eliminar(T entity);
}
