package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShortCircuit implements Circuit {
    private List<Participant> participantList = new ArrayList<>();
    @Override
    public double calculateFee(Participant participant) {
        if (participant.getAge() > 17) {
            return 1300;
        }
        return 1500;
    }

    @Override
    public void subscribe(Participant participant) {
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
                participant.unsubscribe();
                break;
            }
        }
    }


}
