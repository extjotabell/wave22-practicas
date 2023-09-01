package org.example;

public class Curriculum implements Imprimible{
    private String persona;
    private String habilidades;

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona='" + persona + '\'' +
                ", habilidades='" + habilidades + '\'' +
                '}';
    }

    public Curriculum(String persona, String habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }
}
