import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);
        vehiculos.add(vehiculo5);
        vehiculos.add(vehiculo6);
        vehiculos.add(vehiculo7);
        vehiculos.add(vehiculo8);
        vehiculos.add(vehiculo9);
        vehiculos.add(vehiculo10);
        vehiculos.add(vehiculo11);

        Garage garage = new Garage(1, vehiculos);

        //garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        //De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.
        garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca)).forEach(System.out::println);

        /* Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con precios mayor o igual 1000
        y por último, obtén el promedio total de precios de toda la lista de vehículos. */
        List<Vehiculo> listPrecio = new ArrayList<>();
        List<Vehiculo> listPrecio2 = new ArrayList<>();
        listPrecio = garage.getVehiculos().stream().filter(v -> v.getCosto() < 1000).collect(Collectors.toList());
        listPrecio2 = garage.getVehiculos().stream().filter(v -> v.getCosto() >= 1000).collect(Collectors.toList());

        // Obtener el promedio de precios de toda la lista de vehículos
        double promedioTotalPrecios = garage.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0); // Valor predeterminado si no hay elementos

        System.out.println("Vehículos con precio no mayor a 1000: ");
        listPrecio.forEach(System.out::println);

        System.out.println("Vehículos con precio mayor o igual a 1000: ");
        listPrecio2.forEach(System.out::println);

        System.out.println("Promedio total de precios de todos los vehículos: " + promedioTotalPrecios);


    }
}