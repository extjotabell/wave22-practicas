package EjercicioMaraton;

import java.util.ArrayList;
import java.util.List;

public class Inscripcion {

    private int id;

    private Categoria categoria;

    private Participante participante;

    private double monto;

    private static List<Inscripcion> inscripciones = new ArrayList<>();

    private boolean validarInscripcionPrevia(Participante participante){

        for (Inscripcion insc : inscripciones){

            if(participante.getDni().equals(insc.participante.getDni())){
                return false;
            }
        }
        return true;
    }

    private boolean validarInscripcionAvanzada(Categoria categoria, Participante participante){
        if(categoria.getNombre().equals("Circuito Avanzado") && participante.getEdad() < 18){
            return false;
        }
        return true;
    }

    private double calcularMonto(Categoria categoria, Participante participante){
        double costoTotal = 0;
        boolean mayoriaDeEdad = false;
        if(participante.getEdad()>=18){
            mayoriaDeEdad = true;
        }
        if(categoria.getNombre().equals("Circuito Chico")){

            if(mayoriaDeEdad){
                costoTotal = 1500;
            } else {
                costoTotal = 1300;
            }
        } else if(categoria.getNombre().equals("Circuito Medio")){

            if (mayoriaDeEdad) {
                costoTotal = 2300;
            } else {
                costoTotal = 2000;
            }

        } else
            costoTotal = 2800;

        return costoTotal;

    }

    public Inscripcion(int id, Categoria categoria, Participante participante, double monto) {
        if(!validarInscripcionPrevia(participante)){
            throw new RuntimeException("El participante ya se encuentra inscripto");
        }
        if(validarInscripcionAvanzada(categoria, participante)){
            this.id = id;
            this.categoria = categoria;
            this.participante = participante;
            this.monto = calcularMonto(categoria, participante);
            inscripciones.add(this);
        }
    }
}
