package org.example;

public class Auto extends Vehiculo{

    private Integer ruedas;

    public Auto(Double velocidad, Double aceleracion, Double anguloGiro, String patente, Double peso, Integer ruedas) {
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
