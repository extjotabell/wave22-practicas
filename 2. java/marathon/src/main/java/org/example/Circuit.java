package org.example;

public interface Circuit {

    public double calculateFee(Participant participant);

    public void subscribe(Participant participant);

    public int getNumberOfParticipants();

    public double calculateTotalAmount();

    public void unsubscribe(Participant participant);
}
