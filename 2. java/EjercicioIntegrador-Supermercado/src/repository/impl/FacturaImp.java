package repository.impl;

import model.Cliente;
import model.Factura;
import repository.CRUDRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUDRepository<Factura> {

    List<Factura> facturaList = new ArrayList<Factura>();
    @Override
    public void save(Factura objecto) {
        facturaList.add(objecto);
    }

    @Override
    public void mostrarPantalla() {
        facturaList.stream().forEach(System.out::println);
    }

    @Override
    public Optional<Factura> findById(String id) {
        Optional<Factura> facturaEncontrada = facturaList.stream()
                .filter(factura -> factura.getCodigo().equals(id))
                .findFirst();

        if (facturaEncontrada.isPresent()) {
            Factura factura = facturaEncontrada.get();
            System.out.println("Factura encontrada: " + factura);
            return Optional.of(factura); // Retorna el cliente encontrado
        } else {
            System.out.println("Factura con Codigo " + id + " no encontrada.");
            return Optional.empty(); // Retorna Optional.empty() (o cualquier valor predeterminado) cuando no se encuentra el cliente
        }
    }

    @Override
    public void delete(String id) {
        Optional<Factura> facturaEncontrada = facturaList.stream()
                .filter(factura -> factura.getCodigo().equals(id))
                .findFirst();

        facturaEncontrada.ifPresentOrElse(
                factura -> facturaList.remove(factura),
                () -> System.out.println("Factura con Codigo " + id + " no encontrada.")
        );

        mostrarPantalla();
    }

    @Override
    public List<Factura> traerTodos() {
        return facturaList;
    }
}
