import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        Collection<Cliente> clientes = new ArrayList<>();

        Cliente gonzalo = new Cliente(1, "Gonzalo", "España");
        Cliente zadie = new Cliente(2, "Zadie", "Smith");
        Cliente truman = new Cliente(3, "Truman", "Capote");

        clientes.add(gonzalo);
        clientes.add(zadie);
        clientes.add(truman);

        for (Cliente cliente : clientes){
            System.out.println(cliente);
        }

        // Eliminar a un cliente
        clientes.remove(gonzalo);

        // volver a mostrar los clientes
        for (Cliente cliente : clientes){
            System.out.println(cliente);
        }

        // buscar cliente por dni
        int dni_buscado = 3;
        for (Cliente cliente : clientes){
            if (cliente.getDni() == dni_buscado) {
                System.out.println(cliente);
            }
        }

        // Parte II

        // caso particular
        boolean flag = gonzalo.validar_cliente(clientes);
        if (!flag){
            clientes.add(gonzalo);
        }


    }
}