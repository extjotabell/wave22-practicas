package org.example;

public class SocorristaAuto extends Socorrista <Auto>{
    @Override
    public void socorrer(Auto auto) {
        System.out.print("Socorriendo auto : " + auto.getPatente());
    }
}
