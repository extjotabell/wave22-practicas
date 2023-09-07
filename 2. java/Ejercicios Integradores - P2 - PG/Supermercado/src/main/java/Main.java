import model.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        RepositorioFactura repositorioFactura = new RepositorioFactura();

        Cliente cliente1 = new Cliente(3123, "Randy", "Mendoza");
        Cliente cliente2 = new Cliente(64563, "Belen", "Velasquez");
        Cliente cliente3 = new Cliente(43234, "Camila", "rodriguez");

        repositorioCliente.create(cliente1);
        repositorioCliente.create(cliente2);
        repositorioCliente.create(cliente3);

        Item item1 = new Item("asa", "fideos", 2, 100);
        Item item2 = new Item("dasd", "cafe", 1, 50);
        Item item3 = new Item("asda", "arroz", 3, 150);

        List<Item> items = List.of(item1, item2, item3);
        Factura factura1 = new Factura(1, cliente1, items);

        agregarFactura(factura1, repositorioCliente, repositorioFactura);
        System.out.println(repositorioFactura.getAll());
        System.out.println(repositorioCliente.getAll());
        // ahora agregamos una factura con un cliente que no existe

        Factura factura2 = new Factura(2, new Cliente(123,"nico","rodriguez"), items);
        agregarFactura(factura2, repositorioCliente, repositorioFactura);
        System.out.println("Despues de agregar factura con cliente que no existe en la DB");
        System.out.println(repositorioFactura.getAll());
        System.out.println(repositorioCliente.getAll());
        agregarFactura(factura2, repositorioCliente, repositorioFactura);
        System.out.println(repositorioFactura.getAll());

    }

    private static void agregarFactura(Factura factura, RepositorioCliente repositorioCliente, RepositorioFactura repositorioFactura) {
        if (esValidoClienteDeFactura(factura, repositorioCliente)) {
            repositorioFactura.create(factura);
        } else {
            repositorioCliente.create(factura.getCliente());
        }
    }

    private static boolean esValidoClienteDeFactura(Factura factura, RepositorioCliente repositorioCliente) {
        return repositorioCliente.getObjectById(factura.getCliente().getDni()) != null;
    }

}
