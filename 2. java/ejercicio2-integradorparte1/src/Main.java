import dao.entity.Cliente;
import dao.entity.Factura;
import dao.entity.Item;
import services.ClienteService;
import services.impl.ClienteServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteServiceImpl();

        List<Cliente> clientes = new ArrayList<>();

        Cliente cliente = new Cliente("Julio", "Alvarez",
                "42804438", "juliojoel.alvarez@mercadolibre.com",
                "Avenida siempre viva 127");

        Cliente erling = new Cliente("Erling", "Haaland",
                "2823329", "erling.haaland@mercadolibre.com",
                "Manchester City Camp");

        Cliente gian = new Cliente("Gianluca", "Prestianni",
                "3424234", "gian.prestianni@mercadolibre.com",
                "Villa Olimpica Velez");

        clientes.add(cliente);
        clientes.add(erling);
        clientes.add(gian);
        clienteService.setClientes(clientes);
        clienteService.getClientes();

        clienteService.deleteByDni("3424234");
        clienteService.getClientes();


        Item hamburguesas = new Item(1, "Medallones de carne paty x2",
                6, 500);
        Item leche = new Item(2, "Leche entera descremada", 2, 1000);
        Item cafe = new Item(3, "Cafe en granos", 1, 800);


        Factura facturaCliente = new Factura(1, cliente);
        facturaCliente.addItem(hamburguesas);
        facturaCliente.addItem(leche);
        facturaCliente.addItem(cafe);

        facturaCliente.setTotal();

        System.out.println(facturaCliente);
    }
}
