package model;

public class Autor extends Persona {

    private String titulo;
    private String genero;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Autor() {
    }


    public Autor(String nombre, String apellido, int edad, int dni, String titulo, String genero) {
        super(nombre, apellido, edad, dni);
        this.titulo = titulo;
        this.genero = genero;
    }
}
