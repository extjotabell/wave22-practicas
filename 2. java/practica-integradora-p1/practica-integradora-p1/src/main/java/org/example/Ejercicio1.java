package org.example;

import java.util.Arrays;

public class Ejercicio1 {

    public static int[] burbuja(int[] array) {

        return Arrays.stream(array).sorted().toArray();
    }
}
