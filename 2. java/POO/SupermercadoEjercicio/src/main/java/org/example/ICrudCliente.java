package org.example;

public interface ICrudCliente<T> {
    void eliminar(int id);
    void mostrarCliente(T cliente);

}
