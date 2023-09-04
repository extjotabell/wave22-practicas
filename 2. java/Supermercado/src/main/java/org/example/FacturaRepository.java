package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaRepository implements Crud<Factura> {
    private List<Factura> facturas;

    public FacturaRepository() {
        this.facturas = new ArrayList<>();
    }

    @Override
    public void create(Factura obj) {
        this.facturas.add(obj);
    }

    @Override
    public Optional<Factura> read(String id) {
        return this.facturas.stream().filter(f -> f.getCodigo().equals(id)).findFirst();
    }

    @Override
    public void update(Factura obj) {
        facturas.removeIf(f->f.getCodigo().equals(obj.getCodigo()));
        facturas.add(obj);
    }

    @Override
    public void delete(String id) {
        facturas.removeIf(f->f.getCodigo().equals(id));
    }

    @Override
    public List<Factura> getAll() {
        return this.facturas;
    }
}
