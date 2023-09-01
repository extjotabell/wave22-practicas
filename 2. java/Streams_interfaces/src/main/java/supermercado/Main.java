package supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Cliente> listaClientes = new ArrayList<>();

        listaClientes.add(new Cliente("12345678", "Facundo", "Hermida"));
        listaClientes.add(new Cliente("42596009", "Marcos", "Alonso"));
        listaClientes.add(new Cliente("40599303", "Celina", "Fernandez"));

        //****************Listado de clientes****************
        System.out.println("Clientes:");
        listaClientes.forEach(System.out::println);

        //****************Elimino un cliente*****************
        listaClientes.remove(0);

        System.out.println("\nClientes actualizados:");
        listaClientes.forEach(System.out::println);

        //****************Consulta por DNI*******************
        System.out.println("\nIngrese un DNI para consultar:");
        String dniConsulta = scanner.next();

        List<Cliente> listaFiltrada = listaClientes.stream().filter(cliente -> cliente.getDni().equals(dniConsulta)).collect(Collectors.toList());

        if(listaFiltrada.isEmpty()){
            System.out.println("La consulta no devolvió resultados");
        }else{
            listaFiltrada.forEach(System.out::println);
        }

    }
}
