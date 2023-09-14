package org.example;

public class Contadorx2 extends Prototipo{

    public Contadorx2() {
        super(2, 1);
    }

    @Override
    public void NextTo() {

        super.valor= super.valor + contador;
        System.out.println(super.valor);
    }

    @Override
    public void reboot() {
        super.valor=1;
        System.out.println(super.valor);
    }

    @Override
    public void initialValue() {
        super.valor=1;
        System.out.println(super.valor);
    }
}
