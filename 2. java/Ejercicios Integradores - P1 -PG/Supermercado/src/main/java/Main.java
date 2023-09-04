import model.Cliente;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(3123,"Randy","Mendoza");
        Cliente cliente2 = new Cliente(64563,"Belen","Velasquez");
        Cliente cliente3 = new Cliente(43234,"Camila","rodriguez");

        Map<Integer,Cliente> clientes = new HashMap<>();
        clientes.put(cliente1.getDni(),cliente1);
        clientes.put(cliente2.getDni(),cliente2);
        clientes.put(cliente3.getDni(),cliente3);

        clientes.forEach((key,value) -> System.out.println(value));

        // eliminamos uno e iteramos de nuevo
        clientes.remove(3123);
        clientes.forEach((key,value) -> System.out.println(value));

        findClientByDni(clientes);


    }
    private static void findClientByDni(Map<Integer, Cliente> clientes){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente que desea buscar: ");
        int dni = input.nextInt();

        if (clientes.containsKey(dni)) {
            System.out.println(clientes.get(dni));
        } else {
            System.out.println("El cliente no se encuentra en la BD");
        }
    }
}
