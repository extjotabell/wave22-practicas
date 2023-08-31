public class Main {
    public static void main(String[] args) {
        Persona per = new Persona("Nahuel", 28, "", 85, 1.67);

        int IMC = per.calcularIMC();
        boolean esMayor = per.esMayorDeEdad();

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

        System.out.println(per.toString() + '\n'
                + esMayorDeEdad + '\n' + infoIMC);

    }
}
