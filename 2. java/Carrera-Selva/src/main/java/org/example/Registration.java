package org.example;

import java.util.Objects;

public class Registration {
    private int number;
    private Category category;
    private int cost;

    private Participant participant;

    public Registration(Category category, Participant participant) {
        this.number = participant.getDni();
        this.category = category;
        this.participant = participant;
        if(isAllowedRegistration()){
            if(participant.getAge() < 18){
                this.cost = category.getCost().get("Menor");
            } else {
                this.cost =  category.getCost().get("Mayor");
            }
        } else {
            System.out.println("No puede inscribirse");
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public boolean isAllowedRegistration(){
        if((participant.getAge() < 18) && (Objects.equals(category.getTipoCategoria(), "CIRCUITO_AVANZADO")) || participant.getCategory() != null){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "number=" + number +
                ", category=" + category +
                ", cost=" + cost +
                ", participant=" + participant +
                '}';
    }
}
