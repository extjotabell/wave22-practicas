package com.renzobayarri;

public class Main {
    public static void main(String[] args) {
        Prototipo<Long> serieLong = new Prototipo<>(4L);

        serieLong.setInitial(3L);
        System.out.println(serieLong.getNext());
        System.out.println(serieLong.getNext());
        System.out.println(serieLong.getNext());
        serieLong.reset();
        System.out.println(serieLong.getNext());
        System.out.println(serieLong.getNext());
        serieLong.reset();

        Prototipo<Double> seriedouble = new Prototipo<>(36.9);
        System.out.println(seriedouble.getNext());
        System.out.println(seriedouble.getNext());
        seriedouble.reset();
        System.out.println(seriedouble.getNext());
        seriedouble.setInitial(3.0);
        System.out.println(seriedouble.getNext());
    }
}