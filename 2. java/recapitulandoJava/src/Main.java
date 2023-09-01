import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo vehiculo5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Logan", "Renault", 950);

        Garaje garaje1 = new Garaje(1);

        garaje1.setVehiculos(new ArrayList<>(Arrays.asList(
                vehiculo1, vehiculo2, vehiculo3, vehiculo4, vehiculo5,
                vehiculo6, vehiculo7, vehiculo8, vehiculo9, vehiculo10, vehiculo11
        )));

        List<Vehiculo> vehiculosGaraje1 = garaje1.getVehiculos();

        vehiculosGaraje1.sort(Comparator.comparingDouble(Vehiculo::getCosto));
        System.out.println("Ordenar por costo");
        for (Vehiculo vehiculo : vehiculosGaraje1) {
            System.out.println(vehiculo.getModelo() + " " + vehiculo.getMarca() + " " + vehiculo.getCosto());
        }

        Comparator<Vehiculo> comparator = Comparator
                .comparing(Vehiculo::getMarca)
                .thenComparingDouble(Vehiculo::getCosto);

        vehiculosGaraje1.sort(comparator);

        System.out.println("--------------Ordenar por costo y marca------------");
        for (Vehiculo vehiculo : vehiculosGaraje1) {
            System.out.println(vehiculo.getModelo() + " " + vehiculo.getMarca() + " " + vehiculo.getCosto());
        }

        List<Vehiculo> vehiculosMenorOIgual1000 = vehiculosGaraje1.stream()
                .filter(vehiculo -> vehiculo.getCosto() <= 1000)
                .collect(Collectors.toList());

        List<Vehiculo> vehiculosMayorOIgual1000 = vehiculosGaraje1.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());

        double promedioPrecios = vehiculosGaraje1.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);

        System.out.println("--------------Solo menores a 1000 ------------");
        for (Vehiculo vehiculo : vehiculosMenorOIgual1000) {
            System.out.println(vehiculo.getModelo() + " " + vehiculo.getMarca() + " " + vehiculo.getCosto());
        }

        System.out.println("--------------Solo mayores o iguales a 1000 ------------");
        for (Vehiculo vehiculo : vehiculosMayorOIgual1000) {
            System.out.println(vehiculo.getModelo() + " " + vehiculo.getMarca() + " " + vehiculo.getCosto());
        }

        System.out.println("Promedio total :" + promedioPrecios);
    }
}
