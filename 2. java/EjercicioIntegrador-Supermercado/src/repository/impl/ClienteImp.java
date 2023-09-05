package repository.impl;

import model.Cliente;
import repository.CRUDRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDRepository<Cliente> {

    List<Cliente> clienteList = new ArrayList<Cliente>();

    @Override
    public void save(Cliente cliente){
        clienteList.add(cliente);
    }

    @Override
    public void mostrarPantalla() {
        clienteList.stream().forEach(System.out::println);
    }

    @Override
    public Optional<Cliente> findById(String dni) {
        Optional<Cliente> clienteEncontrado = clienteList.stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findFirst();

        if (clienteEncontrado.isPresent()) {
            Cliente cliente = clienteEncontrado.get();
            System.out.println("Cliente encontrado: " + cliente);
            return Optional.of(cliente); // Retorna el cliente encontrado
        } else {
            System.out.println("Cliente con DNI " + dni + " no encontrado.");
            return Optional.empty(); // Retorna Optional.empty() (o cualquier valor predeterminado) cuando no se encuentra el cliente
        }
    }

    @Override
    public void delete(String dni) {
        Optional<Cliente> clienteEncontrado = clienteList.stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findFirst();

        clienteEncontrado.ifPresentOrElse(
                cliente -> clienteList.remove(cliente),
                () -> System.out.println("Cliente con DNI " + dni + " no encontrado.")
        );

        mostrarPantalla();
    }

    @Override
    public List<Cliente> traerTodos() {
        return clienteList;
    }


}
