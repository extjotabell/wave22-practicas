import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Vehiculo fiesta = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo focus = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo explorer = new Vehiculo("Explorer","Ford",2500);
        Vehiculo uno = new Vehiculo("Uno","Fiat",500);
        Vehiculo cronos = new Vehiculo("Cronos","Fiat",1000);
        Vehiculo torino = new Vehiculo("Torino","Fiat",1250);
        Vehiculo aveno = new Vehiculo("Aveno", "Chevrolet", 1250);
        Vehiculo spin = new Vehiculo("Spin","Chevrolet", 2500);
        Vehiculo corola = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo fortuner = new Vehiculo("Fortuner","Toyota",3000);
        Vehiculo logan = new Vehiculo("Logan","Renault",950);

        List<Vehiculo> listVehiculos = new ArrayList();
        listVehiculos.add(fiesta);
        listVehiculos.add(focus);
        listVehiculos.add(explorer);
        listVehiculos.add(uno);
        listVehiculos.add(cronos);
        listVehiculos.add(torino);
        listVehiculos.add(aveno);
        listVehiculos.add(spin);
        listVehiculos.add(corola);
        listVehiculos.add(fortuner);
        listVehiculos.add(logan);

        Garaje garaje = new Garaje(1, listVehiculos);

        //garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        //garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).sorted(Comparator.comparing(Vehiculo::getMarca)).forEach(System.out::println);

        List<Vehiculo> vehiculosEconomicos = garaje.getVehiculos().stream().filter(v -> v.getCosto() < 1000).collect(Collectors.toList());
        List<Vehiculo> vehiculosPremium = garaje.getVehiculos().stream().filter(v -> v.getCosto() >= 1000).collect(Collectors.toList());
        List<OptionalDouble> vehiculoPromedio = Collections.singletonList(garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average());
        double promedioTotalPrecios = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0);
        System.out.println(vehiculoPromedio);
        System.out.println(promedioTotalPrecios);
    }
}
