package org.example;

public class Main {
    public static void main(String[] args) {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones(0, 300);
        double resultado = practicaExcepciones.calculateCociente();
        double resultadoNuevo = practicaExcepciones.calculateCocienteModificado();
        System.out.println(resultado);
        System.out.println(resultadoNuevo);
    }
}

    /*Crear una clase PracticaExcepciones que defina los atributos
a = 0 y b = 300 de tipo int.
        Calcular el cociente de b/a.
        Controlar la excepción que se lanza indicando el mensaje
        “Se ha producido un error”.
        Al final del programa siempre deberá indicar el mensaje
        “Programa finalizado”

        Modificar el programa anterior para que, al producirse el error,
        en vez de imprimir por consola el mensaje “Se ha producido un error”,
        lo lance como una excepción de tipo IllegalArgumentException
        con el mensaje “No se puede dividir por cero”*/
