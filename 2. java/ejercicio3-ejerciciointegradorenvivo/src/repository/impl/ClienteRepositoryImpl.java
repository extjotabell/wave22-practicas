package repository.impl;

import domain.Cliente;
import domain.Localizador;
import domain.Paquete;
import repository.ClienteRepository;

import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepository {
    private List<Localizador> localizadores;
    private List<Paquete> paquetes;

    public ClienteRepositoryImpl() {
    }

    @Override
    public void addLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }

    @Override
    public void buscarReservas(Cliente cliente) {
        for (Paquete paquete : paquetes) {
            if(cliente.getPaquete() == paquete) {
                System.out.println("El cliente tiene el paquete: " + paquete);
            }
        }
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }
}
