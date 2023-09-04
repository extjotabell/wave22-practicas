package main;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numeros = new int[] {5,3,21,43,32,1,45,7};
        int [] ordenado = burbuja(numeros);
        Arrays.stream(ordenado).forEach(System.out::println);
    }

    public static int[] burbuja(int[] array) {
        return Arrays.stream(array).sorted().toArray();
    }
}
