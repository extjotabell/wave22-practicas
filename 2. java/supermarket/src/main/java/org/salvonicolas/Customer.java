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


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Customer) {
            Customer other = (Customer) obj;
            return other.dni.equals(this.dni);
        }
        if (obj instanceof String) {
            return obj.equals(this.dni);
        }
        return false;
    }
}
