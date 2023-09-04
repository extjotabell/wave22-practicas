package parte1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClienteInt clienteInt = new ClienteInt();
        FacturaInt facturaInt = new FacturaInt();
        ItemInt itemInt = new ItemInt();

        Cliente clienteUno= new Cliente("1234567","Valentina","Gottelli");
        Cliente clienteDos = new Cliente("34567890","Delfina","fernandez");
        Cliente clienteTres = new Cliente("12389745","Carlos","Guerrero");

        Item itemUno = new Item("123","Arroz",2,12);
        Item itemDos = new Item("12","Leche",3,34);

        itemInt.guardar(itemUno);
        itemInt.guardar(itemDos);

        List<Item> items = itemInt.traerTodo();

        // creo factura, primero verifico que el cliente exista:

        Factura facturaUno = new Factura(clienteUno,items);

        if(clienteInt.buscar(facturaUno.getCliente().getDni()).isEmpty()){
            clienteInt.guardar(facturaUno.getCliente());
        }

        facturaUno.calcularTotal();

        facturaInt.guardar(facturaUno);

        facturaInt.mostrar();

        clienteInt.guardar(clienteUno);
        clienteInt.guardar(clienteDos);
        clienteInt.guardar(clienteTres);

        clienteInt.mostrar();

        //eliminar cliente

        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese el cliente que quiere eliminar por su nro de dni: " + "\n");

        String dniBorrado= teclado.nextLine();

        clienteInt.eliminar(dniBorrado);

        clienteInt.mostrar();

        //pido datos de cliente

        System.out.printf("Ingrese nro de dni de cliente a buscar: ");
        String pidoDni = teclado.nextLine();
        clienteInt.buscar(pidoDni);











    }
}
