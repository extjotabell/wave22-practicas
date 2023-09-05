package org.example;

public class SocorristaMoto extends Socorrista <Moto>{
    @Override
    public void socorrer(Moto moto) {
        System.out.print("Socorriendo moto : " + moto.getPatente());
    }
}
