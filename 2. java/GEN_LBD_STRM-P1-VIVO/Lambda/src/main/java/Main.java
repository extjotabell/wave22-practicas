import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> listaDeVehiculos = getListaDeVehiculos();

        Garage unGarage = new Garage(1, listaDeVehiculos);

        // Ej 3
        System.out.println("Ej 3: Ordeno por costo");

        List<Vehiculo> vehiculosOrdenadosPorPrecioAscendente =
                                listaDeVehiculos
                                        .stream()
                                        .sorted(Comparator.comparing(Vehiculo::getCosto)).toList();
        // Imprimo rtado por pantalla
        vehiculosOrdenadosPorPrecioAscendente.forEach(System.out::println);

        // Ej 4
        System.out.println("\nEj 4: Ordeno por marca y costo");

        List<Vehiculo> vehiculosOrdenadosPorMarcaYPrecioAscendente =
                listaDeVehiculos
                        .stream()
                        .sorted(Comparator.comparing(Vehiculo::getCosto))
                        .sorted(Comparator.comparing(Vehiculo::getMarca))
                        .toList();
        // Imprimo rtado por pantalla
        vehiculosOrdenadosPorMarcaYPrecioAscendente.forEach(System.out::println);

        // Ej 5
        System.out.println("\nEj 5: Extraer por condiciones");

        // Extraer lista con vehiculos de precio no mayor a 1000
        System.out.println("\nCosto menor o igual a 1000:");
        List<Vehiculo> vehiculosConPrecioNoMayorA1000 =
                listaDeVehiculos
                        .stream()
                        .filter((vehiculo) -> vehiculo.getCosto() <= 1000)
                        .toList();
        // Imprimo rtado por pantalla
        vehiculosConPrecioNoMayorA1000.forEach(System.out::println);

        // Extraer lista con vehiculos de precio mayor o igual 1000
        System.out.println("\nCosto mayor o igual a 1000:");
        List<Vehiculo> vehiculosConPrecioMayorOIgualA1000 =
                listaDeVehiculos
                        .stream()
                        .filter((vehiculo) -> vehiculo.getCosto() >= 1000)
                        .toList();
        // Imprimo rtado por pantalla
        vehiculosConPrecioMayorOIgualA1000.forEach(System.out::println);

        // Extraer lista con vehiculos de precio mayor o igual 1000
        System.out.println("\nPromedio total de precios:");
        double promedioDePrecios =
                listaDeVehiculos
                        .stream()
                        .mapToLong(Vehiculo::getCosto)
                        .average().orElse(-1);
        // Imprimo rtado por pantalla
        System.out.println("El promedio de precios dio: $" + (int)promedioDePrecios);

    }

    private static List<Vehiculo> getListaDeVehiculos() {
        List<Vehiculo> listaDeVehiculos = new ArrayList<>();

        Vehiculo auto1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo auto2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo auto3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo auto4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo auto5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo auto6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo auto7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo auto8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo auto9 = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo auto10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo auto11 = new Vehiculo("Logan", "Renault", 950);

        listaDeVehiculos.add(auto1);
        listaDeVehiculos.add(auto2);
        listaDeVehiculos.add(auto3);
        listaDeVehiculos.add(auto4);
        listaDeVehiculos.add(auto5);
        listaDeVehiculos.add(auto6);
        listaDeVehiculos.add(auto7);
        listaDeVehiculos.add(auto8);
        listaDeVehiculos.add(auto9);
        listaDeVehiculos.add(auto10);
        listaDeVehiculos.add(auto11);

        return listaDeVehiculos;
    }

}
