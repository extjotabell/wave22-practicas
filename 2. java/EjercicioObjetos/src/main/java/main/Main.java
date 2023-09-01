package main;

public class Main {

    public static void main(String[] args) {

        Persona personaSinParam = new Persona();
        Persona personaAlgunosParam = new Persona("Carlos", 26, "123456");
        Persona personaTodosParam = new Persona("Agustina", 26, "123456", 80, 1.75);
        System.out.println(verificarEdad(personaTodosParam));
        System.out.println(verificarIMC(personaTodosParam));
        System.out.println(personaTodosParam.toString());
    }
    public static String verificarEdad(Persona p) {
        boolean res = p.esMayorDeEdad();
        String msg;
        if (res)
            msg = "Es mayor de edad";
        else
            msg = "Es menor de edad";
        return msg;
    }

    public static String verificarIMC(Persona p) {
        int res = p.calcularIMC();
        String msg;
        if(res == -1)
            msg = "Bajo peso";
        else if (res == 0)
            msg = "Saludable";
        else
            msg = "Sobrepeso";
        return msg;
    }
}
