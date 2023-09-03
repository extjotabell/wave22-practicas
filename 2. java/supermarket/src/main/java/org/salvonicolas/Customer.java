package org.salvonicolas;

public class Customer {
    private String dni;
    private String firstName;
    private String lastName;

    public Customer(String dni, String firstName, String lastName) {
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return dni + " " +
                firstName + " " +
                lastName;
    }

    public String getDni() {
        return dni;
    }
}
