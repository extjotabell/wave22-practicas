import dao.entity.Cliente;
import dao.entity.Factura;
import dao.entity.Item;
import dao.entity.Supermercado;
import services.ClienteService;
import services.impl.ClienteServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteServiceImpl();

        Supermercado supermercado = new Supermercado();


        Cliente cliente = new Cliente("Julio", "Alvarez",
                "42804438", "juliojoel.alvarez@mercadolibre.com",
                "Avenida siempre viva 127");

        Cliente erling = new Cliente("Erling", "Haaland",
                "2823329", "erling.haaland@mercadolibre.com",
                "Manchester City Camp");

        Cliente gian = new Cliente("Gianluca", "Prestianni",
                "3424234", "gian.prestianni@mercadolibre.com",
                "Villa Olimpica Velez");

        supermercado.addCliente(cliente);
        supermercado.addCliente(erling);
        supermercado.addCliente(gian);

        clienteService.setClientes(supermercado.getClienteList());
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
        supermercado.addFactura(facturaCliente);

        System.out.println(facturaCliente);


        System.out.println("------- INTEGRADOR PARTE 2--------");
        System.out.println("---------CREANDO NUEVA FACTURA---------");
        Cliente clienteMartin = new Cliente("Martin", "Rodriguez", "4299309",
                "martin@digitalhouse.com", "Digital House 182");
        Factura facturaMartin = new Factura(2, clienteMartin);
        supermercado.addCliente(clienteMartin);
        supermercado.addFactura(facturaMartin);

        System.out.println(facturaMartin);
    }
}
