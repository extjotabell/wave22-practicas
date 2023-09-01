import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        Garaje garaje = new Garaje(1);

        Vehiculo vehiculo1 = new Vehiculo("Ford","Fiesta",1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford","Focus",1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford","Explorer",2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat","Uno",500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos",1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat","Torino",1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet","Spin",2500);
        Vehiculo vehiculo9 = new Vehiculo("Toyota","Corola",1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota","Fortuner",3000);
        Vehiculo vehiculo11 = new Vehiculo("Renault","Logan",950);

        garaje.agregarVehiculo(vehiculo1);
        garaje.agregarVehiculo(vehiculo2);
        garaje.agregarVehiculo(vehiculo3);
        garaje.agregarVehiculo(vehiculo4);
        garaje.agregarVehiculo(vehiculo5);
        garaje.agregarVehiculo(vehiculo6);
        garaje.agregarVehiculo(vehiculo7);
        garaje.agregarVehiculo(vehiculo8);
        garaje.agregarVehiculo(vehiculo9);
        garaje.agregarVehiculo(vehiculo10);
        garaje.agregarVehiculo(vehiculo11);

        List<Vehiculo> vehiculos = garaje.getListaVehiculos();




        // test
        vehiculos.sort(Comparator.comparing(vehiculo -> vehiculo.getCosto()).


                // thenComparing() para seguir comparando una lista
                //solucion ejercicio 3
                        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        //ejercicio 4
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);

        //ejercicio 5



        System.out.println("-------------LISTA ORIGINAL----------------");
        System.out.println(vehiculos);

    }
}