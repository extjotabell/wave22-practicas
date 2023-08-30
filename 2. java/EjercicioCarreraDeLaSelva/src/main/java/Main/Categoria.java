package Main;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private int id;
    private String nombre;
    private String descripcion;
    private int kilometraje;
    private List<Inscripcion> inscripciones;

    public Categoria(int id, String nombre, String descripcion, int kilometraje) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.kilometraje = kilometraje;
        this.inscripciones = new ArrayList<>();
    }

    public void inscribirParticipante(Participante participante) {
        int monto = obtenerCosto(participante.getEdad());
        if(verificarParticipante(participante)) {
            Inscripcion insc = new Inscripcion(participante, monto);
            inscripciones.add(insc);
        }
    }

    public int obtenerCosto(int edad) {
        int monto;
        if(this.id == 1) {
            if(edad < 18) {
                monto =  1300;
            }
            else {
                monto = 1500;
            }
        }
        else if(this.id == 2) {
            if(edad < 18) {
                monto = 2000;
            }
            else {
                monto = 2300;
            }
        }
        else {
            monto = 2800;
        }
        return monto;
    }

    public boolean verificarParticipante(Participante participante) {
        if(this.id == 3 && participante.getEdad() < 18) {
            return false;
        }
        for(Inscripcion insc: inscripciones) {
            if(insc.getParticipante().equals(participante)) {
                return false;
            }
        }
        return true;
    }

    public void desincribirParticipante(Participante participante) {
        Inscripcion inscEliminar = null;
        for(Inscripcion insc: inscripciones) {
            if(insc.getParticipante().equals(participante)) {
                inscEliminar = insc;
            }
        }
        inscripciones.remove(inscEliminar);
    }

    public int getId() {
        return id;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public void mostrarParticipantes() {
        System.out.println("Categoria: "+this.nombre);
        System.out.println("Participantes: ");
        for(Inscripcion insc: inscripciones) {
            System.out.println(insc.getParticipante().toString());
        }
    }

    public int calcularRecaudacion() {
        int acumulado = 0;
        for(Inscripcion insc: inscripciones) {
            acumulado = acumulado + insc.getMonto();
        }
        return acumulado;
    }
}
