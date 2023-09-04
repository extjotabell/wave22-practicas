package dao.entity;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private List<Cliente> clienteList;
    private List<Factura> facturaList;

    public Supermercado(){
        clienteList = new ArrayList<>();
        facturaList = new ArrayList<>();
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public void addFactura(Factura factura) {
        Cliente clienteAux = null;
        for (Cliente cliente: clienteList) {
            if (factura.getCliente() == cliente) {
                clienteAux = cliente;
                facturaList.add(factura);
            }
        }
        if (clienteAux == null) {
            System.out.println("No se encontro un cliente asociado a esa factura." +
                    " Por favor, asocie la factura a un cliente.");
        }
    }

    public void addCliente(Cliente cliente){
        clienteList.add(cliente);
    }

    public void validarCliente(){

    }
}
