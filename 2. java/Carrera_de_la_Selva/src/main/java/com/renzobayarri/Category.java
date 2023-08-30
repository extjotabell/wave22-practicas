package com.renzobayarri;

import java.util.*;

public class Category {

    public static List<Category> categories = new ArrayList<>();

    private int id;

    private String name;

    private String description;

    private double adultPrice;

    private double minorPrice;

    private boolean minorAllowed;

    private Set<Registration> registrationList;

    public Category(int id, String name, String description, double adultPrice, double minorPrice, boolean minorAllowed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.adultPrice = adultPrice;
        this.minorPrice = minorPrice;
        this.minorAllowed = minorAllowed;
        this.registrationList = new HashSet<>();
        categories.add(this);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(double adultPrice) {
        this.adultPrice = adultPrice;
    }

    public double getMinorPrice() {
        return minorPrice;
    }

    public void setMinorPrice(double minorPrice) {
        this.minorPrice = minorPrice;
    }

    public boolean isMinorAllowed() {
        return minorAllowed;
    }

    public void setMinorAllowed(boolean minorAllowed) {
        this.minorAllowed = minorAllowed;
    }

    public Set<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(Set<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    public void printRegistrations(){
        System.out.println("Lista de participantes");
        for(Registration reg : this.registrationList){
            System.out.println("Number: " + reg.getNumber());
            System.out.println("Participant: " + reg.getParticipant().getFirstName() + " " + reg.getParticipant().getLastName());
            System.out.println("Age: " + reg.getParticipant().getAge());
            System.out.println("Cost: " + reg.getCost());
            System.out.println("------------------------------");
        }
        System.out.println("===============================");
    }

    public void removeParticipant(Participant participant){
        if(Objects.isNull(participant.getRegistration())){
            System.out.println("The participant is not registered");
            return;
        }
        if(!participant.getRegistration().getCategory().equals(this)){
            System.out.println("The participant is not registered in the category " + this.name);
            return;
        }
        this.registrationList.remove(participant.getRegistration());
        participant.getRegistration().setActive(false);
        participant.setRegistration(null);
        System.out.println("Participant removed");
        System.out.println("Updated list of participants:");
        this.printRegistrations();
    }

    public double getIncome (){
        return registrationList.stream()
                .filter(Registration::isActive)
                .mapToDouble(Registration::getCost)
                .sum();
    }

    public void printIncome(){
        System.out.println("Income for the category " + this.name);
        System.out.println("Income: " + getIncome());
        System.out.println("--------------------------------------");
    }
}
