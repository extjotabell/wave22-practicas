

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    public static class Categoria{
        String nombreDeCategoria;
        int precioMenorEdad;
        int precioMayorEdad;
        List<Participante> listaDeParticipantes = new ArrayList<Participante>();

        public Categoria(String nombreDeCategoria, int precioMenorEdad, int precioMayorEdad) {
            this.nombreDeCategoria = nombreDeCategoria;
            this.precioMenorEdad = precioMenorEdad;
            this.precioMayorEdad = precioMayorEdad;
        }

        public void inscribir(Participante participante){
            if (!participante.esMayorDeEdad && this.nombreDeCategoria.equals("Avanzado")){
                return;
            }
            listaDeParticipantes.add(participante);
            participante.categoriaInscripta = this;
        }

        public int costoSegunParticipante(Participante participante){
            // Rompe encapsulamiento
            if (participante.esMayorDeEdad){
                return this.precioMayorEdad;
            } else {
                return this.precioMenorEdad;
            }
        }

        public void mostrarInscriptos(){
            for (Participante participante: listaDeParticipantes) {
                System.out.println(participante);
            }
        }
        public void desinscribir(Participante participante){
            this.listaDeParticipantes.remove(participante);
        }

        public int calcularRecaudacion(){
            int sumaDeRecaudacion = 0;
            for (Participante participante: listaDeParticipantes){
                if (participante.esMayorDeEdad){
                    sumaDeRecaudacion += this.precioMayorEdad;
                } else{
                    sumaDeRecaudacion += this.precioMenorEdad;
                }
            }
            return sumaDeRecaudacion;
        }
    }

    public static class Participante{
        String nombre;
        boolean esMayorDeEdad;
        Categoria categoriaInscripta;

        public Participante(String nombre, boolean esMayorDeEdad) {
            this.nombre = nombre;
            this.esMayorDeEdad = esMayorDeEdad;
        }

        //@Override
        public String toString() {
            return "Participante " + nombre + " esMayorDeEdad " + esMayorDeEdad;
        }
    }

    public static void main(String[] args){
        Categoria categoriaChico = new Categoria("Chico", 1300, 1500);
        Categoria categoriaMedio = new Categoria("Medio", 2000, 2300);
        Categoria categoriaAvanzado = new Categoria("Avanzado", 0, 2800);

        Participante participante1 = new Participante("Santi", true);
        categoriaMedio.inscribir(participante1);
        Participante participante2 = new Participante("Belu", true);
        categoriaChico.inscribir(participante2);
        Participante participante3 = new Participante("Facu", false);
        categoriaAvanzado.inscribir(participante3);
        Participante participante4 = new Participante("Felipe", false);
        categoriaChico.inscribir(participante4);

        System.out.println("Para esta persona y categoría saldría: " + categoriaAvanzado.costoSegunParticipante(participante2));

        categoriaChico.mostrarInscriptos();
        //categoriaChico.desinscribir(participante4);
        //categoriaChico.mostrarInscriptos();

        System.out.println("Se recaudó: " + categoriaChico.calcularRecaudacion());
        int sumaDeRecaudaciones = categoriaChico.calcularRecaudacion() + categoriaMedio.calcularRecaudacion() + categoriaAvanzado.calcularRecaudacion();
        System.out.println("Todas las carreras recaudaron: " + sumaDeRecaudaciones);
    }
}
