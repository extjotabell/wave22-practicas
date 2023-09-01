package org.salvonicolas;

public class Main {
    public static void main(String[] args) {
        Series2 series2 = new Series2();
        series2.getNext();
        series2.getNext();

        System.out.println("-------");
        Series3 series3 = new Series3(1);
        series3.getNext();
        series3.getNext();
        series3.reset();
        series3.getNext();

    }
}