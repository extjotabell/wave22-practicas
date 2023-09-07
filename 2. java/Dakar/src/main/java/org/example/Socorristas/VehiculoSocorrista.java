package org.example.Socorristas;

public class VehiculoSocorrista<T>{
    private int id;

    public void socorrer(T t){
        System.out.println("socorriendo un "+t.getClass());
    }
}
