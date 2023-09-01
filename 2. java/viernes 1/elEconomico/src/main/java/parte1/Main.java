package parte1;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente clienteUno= new Cliente("1234567","Valentina","Gottelli");
        Cliente clienteDos = new Cliente("34567890","Delfina","fernandez");
        Cliente clienteTres = new Cliente("12389745","Carlos","Guerrero");

        ArrayList<Cliente> listaClientes = new ArrayList<>();

        listaClientes.add(clienteUno);
        listaClientes.add(clienteDos);
        listaClientes.add(clienteTres);

        //muestro los clientes
        for (Cliente cli: listaClientes) {
            System.out.printf(cli.toString());
        }

        //eliminar cliente

        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese el cliente que quiere eliminar por su nro de dni: " + "\n");

        String dniBorrado= teclado.nextLine();
        boolean bandera= true;

        for (Cliente c : listaClientes){
            if(c.getDni().equals(dniBorrado)){
                listaClientes.remove(c);
                bandera=false;
                break;
            }if (bandera){
                System.out.printf("No se encontro el dni");
            }else {
                System.out.printf("Cliente eliminado");
            }
        }

        System.out.printf("\n");
        for (Cliente cli: listaClientes) {
            System.out.printf(cli.toString());
        }

        //pido datos de cliente

        System.out.printf("Ingrese nro de dni de cliente a buscar: ");
        String pidoDni = teclado.nextLine();

        boolean band=true;

        for (Cliente cli: listaClientes){
            if (Objects.equals(cli.getDni(), pidoDni)){
                System.out.printf(cli.toString());
                band=false;
                break;
            }if(bandera){
                System.out.print("No se encontro el cliente");
            }
        }



    }
}
