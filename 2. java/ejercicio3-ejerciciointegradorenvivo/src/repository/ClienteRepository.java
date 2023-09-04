package repository;

import domain.Cliente;
import domain.Localizador;

public interface ClienteRepository {
    void addLocalizador(Localizador localizador);
    void buscarReservas(Cliente cliente);
}
