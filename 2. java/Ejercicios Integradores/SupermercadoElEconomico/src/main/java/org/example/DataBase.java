package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataBase<T> implements CRUD{
    private List<Cliente> clientes;
    private List<Factura> facturas;

    public DataBase() {
        clientes = new ArrayList<>();
        facturas = new ArrayList<>();
    }

    @Override
    public void alta(Object generico) {
        if(generico instanceof Cliente){
            clientes.add((Cliente) generico);
        }
        else if(generico instanceof Factura){
            facturas.add((Factura) generico);
        }
    }

    @Override
    public T consulta(int opcion, Object id) {
        if(opcion == 1){
            Optional<T> resultado = (Optional<T>) clientes.stream()
                        .filter(n -> n.getDni().equals((String) id))
                        .findFirst();

            if(!resultado.isPresent()){
                return null;
            }
            return (T) resultado.get();
        }
        else if(opcion == 2){
            Optional<T> resultado = (Optional<T>) facturas.stream()
                    .filter(n -> n.getId() == (int) id)
                    .findFirst();
            if(!resultado.isPresent()){
                return null;
            }
            return (T) resultado.get();
        }
        else{
            return null;
        }
    }

    @Override
    public List<T> consultarTodo(int opcion) {
        if(opcion == 1){
            clientes.forEach(cliente -> System.out.println(cliente.getDni()
                    + " " + cliente.getNombre() + " " + cliente.getApellido()));
            return (List<T>) clientes;
        }
        else{
            facturas.forEach(factura -> System.out.println(factura.getCliente().getDni() + " "
            + factura.getTotalCompra()));
            return (List<T>) facturas;
        }
    }

    @Override
    public void baja(Object generico) {
        if(generico instanceof Cliente){
            clientes.remove((Cliente) generico);
        }
        else if(generico instanceof Factura){
            clientes.remove((Factura) generico);
        }
    }

}
