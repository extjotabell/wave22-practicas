package org.example;

import java.lang.reflect.Type;

public class Impresora implements Imprimible{

    @Override
    public void print(Object documento) {
        System.out.println("Imprimiendo documento...");
        System.out.println(documento.toString());
    }
}
