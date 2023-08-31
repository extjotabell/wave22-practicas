package org.example;

public class Participant extends Person{
    private boolean isSubscribed = false;
    public Participant(String name, String id, int age) {
        super(name, id, age);
    }

    public void subscribe() {
        isSubscribed = true;
    }

    public void unsubscribe() {
        isSubscribed = false;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }
}
