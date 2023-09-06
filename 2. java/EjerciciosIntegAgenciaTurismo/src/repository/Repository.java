package repository;

import model.Cliente;

import java.util.Optional;

public interface Repository<T>{

    public void save (T objeto);
    public void mostrarPantalla();
    public Optional<T> buscar (Cliente cliente);
    public void eliminar (Long id);
}
