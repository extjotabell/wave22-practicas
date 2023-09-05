package org.example.repository;

import org.example.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrudFactura implements Crud<Factura>{



    List<Factura> facturas = new ArrayList<>();
    @Override
    public Factura save(Factura nuevo) {

        facturas.add(nuevo);
        return nuevo;
    }

    @Override
    public void delete(int id) {
        facturas = facturas.stream().filter(fact -> fact.getId() != id).collect(Collectors.toList());
    }

    @Override
    public List<Factura> getAll() {
        return facturas;
    }
}
