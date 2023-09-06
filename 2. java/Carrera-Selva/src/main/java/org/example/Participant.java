package org.example;

public class Participant {
    private int number;
    private int dni;
    private String firstname;
    private String lastname;
    private int age;
    private String cellNumber;
    private String emergencyNumber;
    private String bloodType;
    private Category category;

    public Participant(int number, int dni, String firstname, String lastname, int age, String cellNumber, String emergencyNumber, String bloodType) {
        this.number = number;
        this.dni = dni;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.cellNumber = cellNumber;
        this.emergencyNumber = emergencyNumber;
        this.bloodType = bloodType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "number=" + number +
                ", dni=" + dni +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", cellNumber='" + cellNumber + '\'' +
                ", emergencyNumber='" + emergencyNumber + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", category=" + category +
                '}';
    }
}
