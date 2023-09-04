package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Client> clients = new ArrayList<>();

    public static void main(String[] args) {

        Client renzo = new Client("12345678", "Renzo", "Bayarri");
        Client maira = new Client("45678912", "Maira", "Bayarri");
        Client olivia = new Client("78912345", "Olivia", "Bayarri");


        clients.add(renzo);
        clients.add(maira);
        clients.add(olivia);

        clients.forEach(System.out::println);

        clients.remove(olivia);

        clients.forEach(System.out::println);

        lookForDni();
    }

    public static void lookForDni() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter a dni");
        String dni = sc.next();
        Client client = clients.stream()
                .filter(c -> c.getDni().equals(dni))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Dni not found"));

        System.out.println(client);

    }
}