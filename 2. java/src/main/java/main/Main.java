package main;

public class Main {
    public static void main(String[] args) {
        Persona persVacio = new Persona();
        Persona persParcial = new Persona("Juan",27,"1");
        Persona persCompleto = new Persona("Mario",18,"2",80.5,1.73);

        int imc = persCompleto.calcularIMC();
        String mensaje;

        if(persCompleto.esMayorDeEdad()){
            mensaje = "La persona es mayor de edad";
        }else{
            mensaje = "La persona es menor de edad";
        }
        switch (imc){
            case -1 : mensaje+=" y tiene bajo peso";
            break;
            case 0 : mensaje+=" y tiene peso saludable";
                break;
            case 1 : mensaje+=" y tiene sobrepeso";
                break;
        }

        System.out.println(mensaje);
        System.out.println(persCompleto);
        
    }
}
