package org.example;

import java.util.ArrayList;
import java.util.List;

public class Subscription {
    private Circuit circuit;

    public Subscription(Circuit circuit) {
        this.circuit = circuit;
    }

    public void subscribe(Participant participant) {
        circuit.subscribe(participant);
    }

    public double calculateFee(Participant participant) {
        return circuit.calculateFee(participant);
    }

    public int getNumberOfParticipants() {
        return circuit.getNumberOfParticipants();
    }

    public double calculateTotalAmount() {
        return circuit.calculateTotalAmount();
    }

    public void printCurrentParticipantAmount(Participant participant) {
        System.out.println("El monto del participante " + participant.getName() + " es de $" + circuit.calculateFee(participant));
    }

    public void unsubscribe(Participant participant) {
        circuit.unsubscribe(participant);
    }
}
