package org.example;

public class CalculadoraCientifica {

    public int factorial(int a){
        int result = 1;
        for(int i=1; i<=a;i++){
            result *= i;
        }
        return result;
    }


}
