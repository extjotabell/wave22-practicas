import model.Cliente;
import repository.impl.ClienteImp;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("30445932","Mario Roberto", "Santucho");
        Cliente cliente2 = new Cliente("10347912","Rodolfo", "Kusch");
        Cliente cliente3 = new Cliente("23840189","Martin", "Fierro");

        ClienteImp clienteImp = new ClienteImp();

        clienteImp.save(cliente1);
        clienteImp.save(cliente2);
        clienteImp.save(cliente3);

        clienteImp.mostrarPantalla();
        System.out.println("-------------------------");
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni de la persona a borrar");
        String dniBorrado = teclado.nextLine();
        clienteImp.delete(dniBorrado);
        System.out.println("-------------------------");
        clienteImp.findById("30445932");

    }
}