package org.example;

import java.util.ArrayList;

public class Categoria {
    public String nombre;
    public double precioMayores;
    public double precioMenores;
    public ArrayList<Participante> participantes;
    public int nroInscripcionParticipante;

    public Categoria(String nombre, double precioMayores, double precioMenores)
    {
        this.nombre = nombre;
        this.precioMenores = precioMenores;
        this.precioMayores = precioMayores;
        this.participantes = new ArrayList<>();
    }

    public Categoria(String nombre, double precioMayores)
    {
        this.nombre = nombre;
        this.precioMayores = precioMayores;
        this.participantes = new ArrayList<Participante>();
    }

    public void agregarParticipante(Participante participante)
    {
        if(participante.edad < 18 && this.precioMenores == 0)
        {
            //System.out.println("El participante es menor y no puede ser inscripto");
        }
        else
        {
            this.participantes.add(participante);
            nroInscripcionParticipante += 1;
            participante.numeroDeInscripcion = nroInscripcionParticipante;
        }
    }

    public void MostrarParticipantes()
    {
        System.out.println("---Participantes de la categoria " + this.nombre + "---");
        for(int i = 0; i < participantes.size(); i++)
        {
            System.out.println("Participante: " + participantes.get(i).numero + " - Numero de inscripcion:" + participantes.get(i).numeroDeInscripcion + " - Apellido y nombre: " + participantes.get(i).apellido + " " + participantes.get(i).nombre);
        }
    }

    public void eliminarParticipante(Participante participante)
    {
        this.participantes.remove(participante);
    }
    public double ganancias()
    {
        double gananciasTotales = 0;
        for(int i = 0; i < this.participantes.size(); i++)
        {
            if(this.participantes.get(i).edad < 18)
            {
                gananciasTotales += this.precioMenores;
            }
            else gananciasTotales += this.precioMayores;
        }
        return gananciasTotales;
    }
}
