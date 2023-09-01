package org.example;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Participant participant1 = new Participant("Lautaro", "54326543", 17);
        Participant participant2 = new Participant("Ximena", "39876543", 30);
        Participant participant3 = new Participant("Mauro", "39654874", 30);
        Participant participant4 = new Participant("Laura", "55234678", 16);
        Participant participant5 = new Participant("Miguel", "62876435", 12);
        Participant participant6 = new Participant("Lionel", "33016244", 36);

        Circuit shortCircuit = new ShortCircuit(1300, 1500);
        Circuit mediumCircuit = new MediumCircuit(2000, 2300);
        Circuit advancedCircuit = new AdvancedCircuit(2800);

        Subscription shortCircuitSubcription = new Subscription(shortCircuit);
        shortCircuitSubcription.subscribe(participant1);
        shortCircuitSubcription.subscribe(participant2);

        Subscription mediumCircuitSubscription = new Subscription(mediumCircuit);
        mediumCircuitSubscription.subscribe(participant2);
        mediumCircuitSubscription.subscribe(participant3);
        mediumCircuitSubscription.subscribe(participant4);

        Subscription advancedCircuitSubscription = new Subscription(advancedCircuit);
        advancedCircuitSubscription.subscribe(participant5);
        advancedCircuitSubscription.subscribe(participant6);
        advancedCircuitSubscription.unsubscribe(participant6);

        shortCircuitSubcription.printCurrentParticipantAmount(participant1);
        shortCircuitSubcription.printCurrentParticipantAmount(participant2);
        shortCircuitSubcription.printCurrentParticipantAmount(participant3);
        shortCircuitSubcription.printCurrentParticipantAmount(participant4);
        shortCircuitSubcription.printCurrentParticipantAmount(participant5);
        shortCircuitSubcription.printCurrentParticipantAmount(participant6);
        System.out.println("El numero de participantes del circuito chico es " + shortCircuitSubcription.getNumberOfParticipants());
        System.out.println("El numero de participantes del circuito medio es " + mediumCircuitSubscription.getNumberOfParticipants());
        System.out.println("El numero de participantes del circuito avanzado es " + advancedCircuitSubscription.getNumberOfParticipants());
        System.out.println("El total de la subscripcion del circuito corto es de $" + shortCircuitSubcription.calculateTotalAmount());
        System.out.println("El total de la subscripcion del circuito medio es de $" + mediumCircuitSubscription.calculateTotalAmount());
        System.out.println("El total de la subscripcion del circuito avanzado es de $" + advancedCircuitSubscription.calculateTotalAmount());

        List<Subscription> subscriptionList = new ArrayList<>();
        subscriptionList.add(shortCircuitSubcription);
        subscriptionList.add(mediumCircuitSubscription);
        subscriptionList.add(advancedCircuitSubscription);
        double totalAmount = 0;
        for (Subscription subscription : subscriptionList) {
            totalAmount += subscription.calculateTotalAmount();
        }

        System.out.println("El total recaudado de todas las subscripciones es: $" + totalAmount);
    }
}