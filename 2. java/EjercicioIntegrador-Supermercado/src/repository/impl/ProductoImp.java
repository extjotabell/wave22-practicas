package repository.impl;

import model.Factura;
import model.Producto;
import repository.CRUDRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoImp implements CRUDRepository<Producto> {

    List<Producto> productoList = new ArrayList<Producto>();
    @Override
    public void save(Producto objecto) {
        productoList.add(objecto);
    }

    @Override
    public void mostrarPantalla() {
        productoList.stream().forEach(System.out::println);
    }

    @Override
    public Optional<Producto> findById(String id) {
        Optional<Producto> productoEncontrado = productoList.stream()
                .filter(producto -> producto.getCodigo().equals(id))
                .findFirst();

        if (productoEncontrado.isPresent()) {
            Producto producto = productoEncontrado.get();
            System.out.println("Producto encontrado: " + producto);
            return Optional.of(producto); // Retorna el cliente encontrado
        } else {
            System.out.println("Producto con Codigo " + id + " no encontrado.");
            return Optional.empty(); // Retorna Optional.empty() (o cualquier valor predeterminado) cuando no se encuentra el cliente
        }
    }

    @Override
    public void delete(String id) {
        Optional<Producto> productoEncontrado = productoList.stream()
                .filter(producto -> producto.getCodigo().equals(id))
                .findFirst();

        productoEncontrado.ifPresentOrElse(
                producto -> productoList.remove(producto),
                () -> System.out.println("Producto con Codigo " + id + " no encontrado.")
        );

        mostrarPantalla();
    }

    @Override
    public List<Producto> traerTodos() {
        return productoList;
    }
}
