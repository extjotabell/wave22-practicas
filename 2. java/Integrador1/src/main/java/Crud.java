import java.util.Optional;

public interface Crud<T> {
    void alta(T alta);
    void baja(T baja);
    Optional<T> consulta(int id);
}
