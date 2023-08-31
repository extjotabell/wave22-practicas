package org.example;
import java.util.HashSet;
import java.util.Set;

public class Categoria {
    private Integer precioMenor;
    private Integer precioMayor;
    private Integer edadMin;
    private Integer recaudacion;
    private Integer inscripciones;
    private Set<Participante> participantes;

    public Categoria(Integer precioMenor, Integer precioMayor, Integer edadMin){
        this.precioMayor = precioMayor;
        this.precioMenor = precioMenor;
        this.edadMin = edadMin;
        this.recaudacion = 0;
        this.inscripciones = 0;
        this.participantes = new HashSet<>();
    }

    public void inscribir(Participante participante){
        if(!participante.getEstado()){
            if (participante.getEdad() >= edadMin) {
                if (participante.getEdad() >= 18) {
                    this.recaudacion += this.precioMayor;
                    System.out.println("Debe abonar: " + this.precioMayor);
                } else {
                    this.recaudacion += this.precioMenor;
                    System.out.println("Debe abonar: " + this.precioMenor);
                }
                participante.setEstado(true);
                participante.setNroInscripcion(this.generarNroInscripcion());
                this.participantes.add(participante);
            } else {
                System.out.println("El participante no tiene la edad suficiente");
            }
        }
        else {
            System.out.println("El participante ya esta inscirpto en una categoria");
        }

    }

    public void desinscribir(Participante participante){
        if (participantes.contains(participante)){

            if (participante.getEdad() >= 18){
                this.recaudacion -= this.precioMayor;
            }
            else {
                this.recaudacion -= this.precioMenor;
            }
            participante.setEstado(false);
            participante.setNroInscripcion(0);
            participantes.remove(participante);
            System.out.println("Deinscripcion Exitosa!");
        }
        else {
            System.out.println("Participante no encontrado");
        }
    }

    public void mostrarParticipantes(){
        for (Participante participante : this.participantes) {
            System.out.println("Nombre: " + participante.getNombre()+" "+participante.getApellido()+ "----Nro Inscripcion: "+participante.getNroInscripcion());
        }
    }

    public Integer getRecaudacion() {
        return recaudacion;
    }

    private Integer generarNroInscripcion() {
        return this.inscripciones+=1;
    }
}
