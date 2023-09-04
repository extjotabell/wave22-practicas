import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();

        Cliente nicolas = new Cliente(1, "Nicolas", "Guglielmi");

        clientes.add(nicolas);
        clientes.add(new Cliente(2, "Maximo", "Guglielmi"));
        clientes.add(new Cliente(3, "Lucia", "Guglielmi"));

        // Muestro clientes
        mostrarClientes(clientes);

        // Remuevo un cliente
        clientes.remove(nicolas);

        // Verifico que el cliente removido no está
        mostrarClientes(clientes);

        // Busco un cliente entre los clientes
        buscarCliente(clientes);

    }

    private static void buscarCliente(List<Cliente> clientes) {
        int dniABuscar = getDniABuscar();

        for (Cliente cliente : clientes) {
            if (cliente.dniEquals(dniABuscar)){
                System.out.println("Se encontro un cliente con ese DNI:");
                System.out.println(cliente);
                return;
            }
        }
        System.out.println("No se encontro un cliente con ese DNI");
    }

    private static int getDniABuscar() {
        // Crea un objeto Scanner para leer desde la consola
        Scanner scanner = new Scanner(System.in);

        // Lee el número ingresado por el usuario
        int dniABuscar = -1;
        for (int i = 2; i >= 0; i--) {
            try {
                // Pide al usuario que ingrese un número
                System.out.print("Por favor ingresa el DNI del cliente a buscar: ");
                dniABuscar = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("El valor ingresado no corresponde lo pedido. Le quedan " + i + " intentos.");
                scanner.nextLine();
            }
            if (dniABuscar != -1) break;
        }

        // Cierra el objeto Scanner
        scanner.close();
        return dniABuscar;
    }

    private static void mostrarClientes(List<Cliente> clientes) {
        System.out.println("Mostrando clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

}
