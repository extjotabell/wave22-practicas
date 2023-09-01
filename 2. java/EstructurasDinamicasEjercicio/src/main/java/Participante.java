public class Participante {
    int number;
    String dni;
    String name;
    String last_name;
    int age;
    String cellphone;
    String emergency_number;
    String blood_type;
    int category;

    public Participante(int number, String dni, String name, String last_name, int age, String cellphone, String emergency_number, String blood_type) {
        this.number = number;
        this.dni = dni;
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.cellphone = cellphone;
        this.emergency_number = emergency_number;
        this.blood_type = blood_type;
    }

    public Participante(int number, String dni, String name, String last_name, int age, String cellphone, String emergency_number, String blood_type, int category) {
        this.number = number;
        this.dni = dni;
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.cellphone = cellphone;
        this.emergency_number = emergency_number;
        this.blood_type = blood_type;
        this.category = category;
    }
}
