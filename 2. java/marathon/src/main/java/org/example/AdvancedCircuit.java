package org.example;

public class AdvancedCircuit extends Circuit {

    public AdvancedCircuit(double childFee) {
        super(childFee);
    }
    @Override
    public double calculateFee(Participant participant) {
        if (participant.getAge() < 18) {
            throw new RuntimeException("No se puede obtener el monto de un menor de edad");
        }
        return childFee;
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
}
