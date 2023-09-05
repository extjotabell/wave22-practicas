package domain;

public class Auto extends Vehiculo {
    private Double peso;
    private int ruedas;
    public Auto(Double velocidad, Double aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.peso = 1000.00;
        this.ruedas = 4;
    }

}
