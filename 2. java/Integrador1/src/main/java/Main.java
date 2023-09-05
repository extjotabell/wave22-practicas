import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(35983934, "Cecilia", "Morlacchi");
        Cliente cliente2 = new Cliente(30383161, "Ivan", "Basualdo");
        Cliente cliente3 = new Cliente(12345678, "Emma", "Basualdo" );

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        for (Cliente cliente : clientes){
            System.out.println(cliente.toString());
        }

        clientes.remove(1);
        System.out.println("-------------------");
        for (Cliente cliente : clientes){
            System.out.println(cliente.toString());
        }

        Scanner dni = new Scanner(System.in);
        int dniIngresado;
        System.out.println("Ingrese el dni del cliente a buscar");
        dniIngresado = dni.nextInt();

        boolean bandera = false;
        for (Cliente cliente : clientes){
            if(cliente.getDni() == dniIngresado){
                System.out.println(cliente.toString());
                bandera = true;
                break;
            }
        }

        if(bandera == false){
            System.out.println("No se encontro al cliente");
        }

        List<Item> items = new ArrayList<>();
        items.add(new Item(1,"cafe",1,100));
        items.add(new Item(2,"azucar", 2, 150));
        items.add(new Item(3,"te", 1, 50));
        Factura factura1 = new Factura(cliente1,items);
        System.out.println(factura1);

        RepositorioCliente repositorio = new RepositorioCliente();

        repositorio.alta(cliente1);
        repositorio.consulta(35983934);
        repositorio.baja(cliente1);
        repositorio.consulta(35983934);
    }
}
