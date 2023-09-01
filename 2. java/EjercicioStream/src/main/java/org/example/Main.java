package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Vehicle("Fiesta", "Ford", 1000));
        vehicles.add(new Vehicle("Focus", "Ford", 1200));
        vehicles.add(new Vehicle("Explorer", "Ford", 2500));
        vehicles.add(new Vehicle("Uno", "Fiat", 500));
        vehicles.add(new Vehicle("Cronos", "Fiat", 1000));
        vehicles.add(new Vehicle("Torino", "Fiat", 1250));
        vehicles.add(new Vehicle("Aveo", "Chevrolet", 1250));
        vehicles.add(new Vehicle("Spin", "Chevrolet", 2500));
        vehicles.add(new Vehicle("Corolla", "Toyota", 1200));
        vehicles.add(new Vehicle("Fortuner", "Toyota", 3000));
        vehicles.add(new Vehicle("Logan", "Renault", 950));

        List<Vehicle> vehiclesSortedByCost = vehicles.stream()
                .sorted(Comparator.comparing(Vehicle::getCost))
                .collect(Collectors.toList());

        List<Vehicle> vehiclesSortedByBrandAndCost = vehicles.stream()
                .sorted(Comparator.comparing(Vehicle::getBrand).thenComparing(Vehicle::getCost))
                .collect(Collectors.toList());

        List<Vehicle> vehiclesWithCostBelow1000 = vehicles.stream()
                .filter(vehicle -> vehicle.getCost() < 1000)
                .collect(Collectors.toList());

        List<Vehicle> vehiclesWithCostEqualOrAbove1000 = vehicles.stream()
                .filter(vehicle -> vehicle.getCost() >= 1000)
                .collect(Collectors.toList());

        double vehiclesAverageCost = vehicles.stream()
                .mapToDouble(Vehicle::getCost).average()
                .orElse(0);

        System.out.print(" Vehicles sorted by cost: " +vehiclesSortedByCost);
        System.out.print("\n\nVehicles sorted by brand and cost: " + vehiclesSortedByBrandAndCost);
        System.out.print("\n\nVehicles sorted costing less than 1000: " + vehiclesWithCostBelow1000);
        System.out.print("\n\nVehicles sorted costing equal or more than 1000: " + vehiclesWithCostEqualOrAbove1000);
        System.out.printf("\n\nVehicles average cost: %.2f", vehiclesAverageCost);

    }
}