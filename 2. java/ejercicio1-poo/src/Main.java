import domain.Persona;

public class Main {
    public static void main(String[] args) {

        Persona personaUno = new Persona();
        Persona personaDos = new Persona("Julio", 22, "42804438");
        Persona personaTres = new Persona("Alejandro", 21, "43578930", 80.0, 1.87);

        // Esto no es posible porque no existe un constructor que tenga este orden de parametros
        //Persona personaCuatro = new Persona("Pablo");
        //Persona personaCinco = new Persona(2);

        int IMC = personaTres.calcularIMC();
        boolean esMayor = personaTres.esMayor();

        String infoIMC = "";

        if (IMC == -1){
            infoIMC = "Bajo peso";
        } else if (IMC == 0) {
            infoIMC = "Peso saludable";
        } else {
            infoIMC = "Sobrepeso";
        }

        String esMayorDeEdad = "Es mayor de edad";
        if(esMayor == false){
            esMayorDeEdad = "Es menor de edad";
        }

        System.out.println(
                personaTres.toString() + "\n" +
                        esMayorDeEdad + "\n" +
                        infoIMC
        );

    }
}