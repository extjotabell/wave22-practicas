import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("0", "A", "A"));
        clientes.add(new Cliente("1", "B", "B"));
        clientes.add(new Cliente("2", "C", "C"));

        for (Cliente c : clientes) {
            System.out.println(c);
        }

        clientes.removeIf(value -> value.dni == "1");
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese un dni para buscar");

        String entry = scan.next();

        Cliente result =  clientes.stream().filter(x -> x.dni.equals(entry)).findFirst().orElse(null);

        if(result != null){
            System.out.println(result);
        }
        else {
            System.out.println("No se encontró el cliente");
        }
    }
}
