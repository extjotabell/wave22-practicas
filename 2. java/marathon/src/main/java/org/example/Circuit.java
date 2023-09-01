package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Circuit {

    protected List<Participant> participantList = new ArrayList<>();
    protected double childFee;
    protected double adultFee;

    public Circuit(double childFee) {
        this.childFee = childFee;
    }
    public Circuit(double childFee, double adultFee) {
        this.childFee = childFee;
        this.adultFee = adultFee;
    }

    public double calculateFee(Participant participant) {
        if (participant.getAge() > 17) {
            return childFee;
        }
        return adultFee;
    }

    public void subscribe(Participant participant) {
        // if (participant.isSubscribed()) throw new RuntimeException("Already subscribed");
        if (participant.isSubscribed()) {
            System.out.println("El participante " + participant.getName() + " ya esta inscripto!");
            return;
        }
        participantList.add(participant);
        participant.subscribe();
    }

    public int getNumberOfParticipants() {
        return participantList.size();
    }

    public double calculateTotalAmount() {
        double amount = 0;
        for(Participant participant : participantList) {
            amount += this.calculateFee(participant);
        }
        return amount;
    }

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
