package com.renzobayarri;

import java.util.Objects;
import java.util.Random;

public class Registration {

    private int number;

    private Category category;

    private Participant participant;

    private double cost;

    private boolean active;


    public Registration(int number, Category category, Participant participant) {
        if(isAllowedRegistration(category, participant)) {
            this.number = number;
            this.category = category;
            this.participant = participant;
            calculateCost();
            participant.setRegistration(this);
            this.category.getRegistrationList().add(this);
            this.active = true;
        }else{
            throw new RuntimeException("Registration not allowed");
        }
    }

    public Registration (int number, Participant participant){

        Category randomCategory = null;
        do {
            Random r = new Random();
            int randomCategoryPosition = r.nextInt(0, Category.categories.size());
            randomCategory = Category.categories.get(randomCategoryPosition);
        } while (!isAllowedRegistration(randomCategory, participant));
        this.number = number;
        this.participant = participant;
        this.category = randomCategory;
        calculateCost();
        participant.setRegistration(this);
        this.category.getRegistrationList().add(this);
        this.active = true;
    }

    public void calculateCost (){
        if(participant.getAge() < 18){
            this.cost = category.getMinorPrice();
        }else{
            this.cost = category.getAdultPrice();
        }
    }

    public boolean isAllowedRegistration(Category category, Participant participant){
        boolean isAdult = participant.getAge() >= 18;
        return (category.isMinorAllowed() || isAdult) && Objects.isNull(participant.getRegistration());
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
