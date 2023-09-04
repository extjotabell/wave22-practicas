package org.example;

public class Client {

    private String dni;

    private String firstName;

    private String lastName;

    public Client() {
    }

    public Client(String dni, String firstName, String lastName) {
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        Main.clients.add(this);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "dni='" + dni + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
