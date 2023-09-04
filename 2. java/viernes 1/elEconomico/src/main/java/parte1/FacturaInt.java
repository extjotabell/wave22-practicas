package parte1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FacturaInt implements crud<Factura>{
    ArrayList<Factura> facturas = new ArrayList<>();

    @Override
    public void guardar(Factura obj) {
        facturas.add(obj);
    }

    @Override
    public void mostrar() {
        for(Factura fact : facturas){
            System.out.printf(fact.toString());
        }
    }

    @Override
    public void eliminar(String id) {

        Optional<Factura> fact = this.buscar(id);

        if(fact.isEmpty()){
            System.out.print("La factura no fue borrada");
        }else{
            this.facturas.remove(fact.get());
            System.out.print("La factura fue borrada");
        }
    }

    @Override
    public Optional<Factura> buscar(String id) {
        boolean band= true;

        for (Factura fac: facturas){
            if (Objects.equals(fac.getCliente().getDni(),id)) {
                System.out.printf(fac.toString());
                band=false;
                return Optional.of(fac);
            }if(band){
                System.out.print("No se encontro la factura");
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Factura> traerTodo() {
        return facturas;
    }
}
