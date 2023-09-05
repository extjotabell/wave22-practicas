package org.example;

public class Moto extends Vehiculo{

    private Integer ruedas;

    public Moto(Double velocidad, Double aceleracion, Double anguloGiro, String patente, Double peso, Integer ruedas) {
        super(velocidad, aceleracion, anguloGiro, patente, peso, ruedas);
        this.ruedas = ruedas;
    }


    public Integer getRuedas() {
        return ruedas;
    }

    public void setRuedas(Integer ruedas) {
        this.ruedas = ruedas;
    }
}
