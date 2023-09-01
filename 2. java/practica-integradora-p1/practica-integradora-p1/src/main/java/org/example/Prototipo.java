package org.example;

public class Prototipo {

    private static Integer numeroActual = 0;
    private static Integer inicio = 1;

    public Integer siguiente(){
        numeroActual += inicio;
        return numeroActual;
    }

    public void inicio(Integer num){
        inicio = num;
    }

    public void reiniciar (){
        numeroActual = 0;
        inicio=1;
    }
}
