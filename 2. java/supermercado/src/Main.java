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

        for (Cliente cliente: listaClientes) {
            System.out.println(cliente.toString());
        }
        //System.out.println("Eliminamos el primer cliente");
        //listaClientes.remove(0);
        //for (Cliente cliente: listaClientes) {
          //  System.out.println(cliente.toString());
        //}
        encontrarClientePorDNI(listaClientes);

    }

    public static void encontrarClientePorDNI(List<Cliente> listaClientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el DNI del cliente ");
        String dniBuscado = scanner.nextLine();

        boolean clienteEncontrado = false;
        if (!dniBuscado.isEmpty()) {
            for (Cliente cliente: listaClientes) {
                if (cliente.DNI.equals(dniBuscado)){
                    System.out.println(cliente.toString());
                    clienteEncontrado = true;
                    break;
                }
            }
        }
        if (!clienteEncontrado) {
            System.out.println("Cliente no encontrado");
        }

    }
}