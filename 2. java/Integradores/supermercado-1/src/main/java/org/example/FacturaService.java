package org.example;

import java.util.HashSet;
import java.util.Set;

public class FacturaService implements CRUD<Factura, Integer> {
    private Set<Factura> facturas = new HashSet<>();

    @Override
    public void save(Factura factura) {
        facturas.add(factura);
    }

    @Override
    public void delete(Integer id) {
        facturas.removeIf(f -> f.getId().equals(id));
    }

    @Override
    public Factura update(Factura factura) {
        return null;
    }

    @Override
    public Factura findById(Integer id) {
        return facturas.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void printAll() {

    }
}


