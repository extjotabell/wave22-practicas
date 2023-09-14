package org.example;

import java.util.List;
import java.util.Optional;

public interface CRUD<T> {
    void alta(T generico);
    T consulta(int opcion, T id);
    List<T> consultarTodo(int opcion);
    void baja(T generico);

}
