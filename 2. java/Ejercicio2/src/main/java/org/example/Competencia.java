package org.example;

import java.util.ArrayList;
import java.util.List;

public class Competencia {
    public String nombre;
    public ArrayList<Categoria> categorias;
    public Competencia(String nombre)
    {
        this.nombre = nombre;
        this.categorias = new ArrayList<>();
    }
    public void agregarCategoria(Categoria categoria)
    {
        this.categorias.add(categoria);
    }
    public double gananciasTotales()
    {
        double ganancias = 0;
        for(int i = 0; i < this.categorias.size(); i++)
        {
            ganancias += this.categorias.get(i).ganancias();
        }
        return ganancias;
    }
    public void inscribirParticipante(Participante participante, Categoria categoria)
    {
        categoria.agregarParticipante(participante);
    }
    public void desinscribirParticipante(Participante participante, Categoria categoria)
    {
        System.out.println("---Desinscribir participante---");
        System.out.println("Desinscribir participante " + participante.nombre + " " + participante.apellido + " - Numero de inscripcion: " + participante.numeroDeInscripcion);
        categoria.eliminarParticipante(participante);
        System.out.println("Participante" + participante.nombre + "desinscripto exitosamente!");
    }
    public void mostrarParticipantes()
    {
        System.out.println("---Mostrando participantes inscriptos a la competencia " + this.nombre + "---");
        for(int i = 0; i < this.categorias.size(); i++)
        {
            this.categorias.get(i).MostrarParticipantes();
        }
    }
}
