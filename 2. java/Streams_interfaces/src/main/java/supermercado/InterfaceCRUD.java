package supermercado;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface InterfaceCRUD<T> {
    void alta(T objeto);

    void baja(Integer id);

    void modificacion(T objeto);

    Optional<T> consulta(Integer id);

    List<T> obtenerTodos();
}
