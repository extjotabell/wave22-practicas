package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdvancedCircuit implements Circuit {
    private List<Participant> participantList = new ArrayList<>();
    @Override
    public double calculateFee(Participant participant) {
        if (participant.getAge() < 18) {
            throw new RuntimeException("No se puede obtener el monto de un menor de edad");
        }
        return 2800;
    }

    @Override
    public void subscribe(Participant participant) {
        // if (participant.getAge() < 18) throw new RuntimeException("Un menor de edad no puede inscribirse");
        if (participant.getAge() < 18) {
            System.out.println("El participante " + participant.getName() + " es menor de edad y no puede inscribirse");
            return;
        }
        // if (participant.isSubscribed()) throw new RuntimeException("Already subscribed");
        if (participant.isSubscribed()) {
            System.out.println("El participante " + participant.getName() + " ya esta inscripto!");
            return;
        }
        participantList.add(participant);
        participant.subscribe();
    }

    @Override
    public int getNumberOfParticipants() {
        return participantList.size();
    }

    @Override
    public double calculateTotalAmount() {
        double amount = 0;
        for(Participant participant : participantList) {
            amount += this.calculateFee(participant);
        }
        return amount;
    }

    @Override
    public void unsubscribe(Participant participant) {
        for (Participant aParticipant: participantList) {
            if (participant.equals(aParticipant)) {
                participantList = participantList.stream().filter(anotherParticipant -> !anotherParticipant.equals(participant)).collect(Collectors.toList());
                participant.unsubscribe();
                break;
            }
        }
    }
}
