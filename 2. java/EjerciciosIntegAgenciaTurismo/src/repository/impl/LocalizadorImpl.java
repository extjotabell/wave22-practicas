package repository.impl;

import model.Cliente;
import model.Localizador;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LocalizadorImpl implements Repository<Localizador> {

    List<Localizador> localizadorList = new ArrayList<Localizador>();

    @Override
    public void save(Localizador objeto) {
        localizadorList.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        localizadorList.stream().forEach(System.out::println);
    }

    @Override
    public Optional<Localizador> buscar(Cliente cliente) {
        Optional<Localizador> localizadorEncontrado = localizadorList.stream()
                .filter(localizador -> localizador.getCliente().equals(cliente))
                .findFirst();
        if (localizadorEncontrado.isPresent()) {
            Localizador localizador = localizadorEncontrado.get();
            System.out.println("Localizador encontrado: " + localizador);
            return Optional.of(localizador); // Retorna el cliente encontrado
        } else {
            System.out.println("Localizador con DNI " + cliente + " no encontrado.");
            return Optional.empty(); // Retorna Optional.empty() (o cualquier valor predeterminado) cuando no se encuentra el cliente
        }
    }

    @Override
    public void eliminar(Long id) {

    }

}
