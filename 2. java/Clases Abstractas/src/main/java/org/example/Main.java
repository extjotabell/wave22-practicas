package org.example;
import org.example.models.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("------- SERIE 2 --------");
        Serie2 serie21 = new Serie2();
        serie21.getNext();
        serie21.getNext();
        serie21.getNext();
        serie21.getNext();
        System.out.println("------- SERIE 2 CON INIT: 1 --------");
        Serie2 serie22 = new Serie2(1);
        serie22.getNext();
        serie22.getNext();
        serie22.getNext();
        serie22.getNext();

        System.out.println("------- SERIE 3 --------");
        Serie3 serie31 = new Serie3();
        serie31.getNext();
        serie31.getNext();
        serie31.getNext();
        serie31.getNext();
        System.out.println("------- SERIE 3 CON INIT 1--------");
        Serie3 serie32 = new Serie3(1);
        serie32.getNext();
        serie32.getNext();
        serie32.getNext();
        serie32.getNext();

        System.out.println("--- RESET:");
        serie32.reset();
        serie32.getNext();
        serie32.getNext();
        serie32.getNext();
        serie32.getNext();
    }
}