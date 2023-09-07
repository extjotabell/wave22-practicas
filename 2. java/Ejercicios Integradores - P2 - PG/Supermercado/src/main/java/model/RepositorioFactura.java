package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RepositorioFactura implements CRUD {
    public RepositorioFactura() {
    }


    private List<Factura> facturas = new ArrayList<>();

    @Override
    public void create(Object o) {
        facturas.add((Factura) o);
    }

    @Override
    public void delete(int id) {
        facturas = facturas.stream().filter(factura -> factura.getId() != id).collect(Collectors.toList());
    }

    @Override
    public void update(int id, Object newObj) {
        Optional<Factura> factura = facturas.stream().filter(fact -> fact.getId() == id).findFirst();

        if (factura.isPresent()) {
            int index = facturas.indexOf(factura.get());
            facturas.set(index, (Factura) newObj);
        }
    }

    @Override
    public List<Factura> getAll() {
        return facturas;
    }

    @Override
    public Object getObjectById(int id) {
        return facturas.stream().filter(factura -> factura.getId() == id).findFirst().orElseThrow();
    }
}
