package org.example;

public class Main {
    public static void main(String[] args) {
        SerieDos serieDos = new SerieDos(2);
        SerieTres serieTres = new SerieTres(0);

        System.out.println(serieDos.valorSig());
        System.out.println(serieDos.valorSig());
        System.out.println(serieDos.valorSig());
        serieDos.resetSerie();
        System.out.println(serieDos.valorSig());

        System.out.println(serieTres.valorSig());
        System.out.println(serieTres.valorSig());
        System.out.println(serieTres.valorSig());
        System.out.println(serieTres.valorSig());
        serieTres.resetSerie();
        System.out.println(serieTres.valorSig());

    }
}