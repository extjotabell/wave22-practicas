import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<>();
        Cliente cliente1 = new Cliente("123456789A", "Juan", "Pérez");
        Cliente cliente2 = new Cliente("987654321B", "María", "Gómez");
        Cliente cliente3 = new Cliente("555555555C", "Carlos", "López");

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString());
        }

        crearFactura(listaClientes);
    }

    public static void crearFactura(List<Cliente> listaClientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el DNI del cliente para la factura: ");
        String dniBuscado = scanner.nextLine();

        Cliente clienteFactura = encontrarClientePorDNI(listaClientes, dniBuscado);

        if (clienteFactura == null) {
            System.out.println("El cliente no existe");
            return;
        }

        Factura factura = new Factura(clienteFactura);

        Producto producto1 = new Producto("P001", "Camiseta", 50, 19.99);
        Producto producto2 = new Producto("P002", "Pantalón", 30, 29.99);

        factura.agregarProducto(producto1);
        factura.agregarProducto(producto2);

        double totalFactura = factura.getPrecioTotal();
        System.out.println("El total de la factura es: " + totalFactura);

    }

    public static Cliente encontrarClientePorDNI(List<Cliente> listaClientes, String dniBuscado) {
        Cliente clienteEncontrado = null;
        if (!dniBuscado.isEmpty()) {
            for (Cliente cliente : listaClientes) {
                if (cliente.getDNI().equals(dniBuscado)) {
                    clienteEncontrado = cliente;
                    break;
                }
            }
        }
        return clienteEncontrado;
    }
}