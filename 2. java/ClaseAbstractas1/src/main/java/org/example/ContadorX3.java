package org.example;

public class ContadorX3 extends Prototipo{

    public ContadorX3() {
        super(3,0);
    }

    @Override
    public void NextTo() {

        super.valor= super.valor + contador;
        System.out.println(super.valor);
    }

    @Override
    public void reboot() {
        super.valor=0;
        System.out.println(super.valor);
    }

    @Override
    public void initialValue() {
        super.valor=0;
        System.out.println(super.valor);
    }
}
