package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        vehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        vehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        vehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garage garage = new Garage(1, vehiculos);

        System.out.println("Vehículos ordenados por precio:");
        garage.getVehiculos().stream().sorted((x,y)->x.getCosto().compareTo(y.getCosto())).forEach(System.out::println);

        System.out.println("\nVehículos ordenados por nombre y precio");
        garage.getVehiculos().stream().sorted((x,y)->x.getCosto().compareTo(y.getCosto())).sorted((x,y)->x.getMarca().compareTo(y.getMarca())).forEach(System.out::println);

        List<Vehiculo> vehiculosMenorMil = garage.getVehiculos().stream().filter(v -> v.getCosto() < 1000).collect(Collectors.toList());

        List<Vehiculo> vehiculosMayorIgualMil = garage.getVehiculos().stream().filter(v -> v.getCosto() >= 1000).collect(Collectors.toList());

        double avgCostos = 0.0;

        avgCostos = garage.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0);

        System.out.println("\nEl promedio de costos es: "+avgCostos);

    }
}
