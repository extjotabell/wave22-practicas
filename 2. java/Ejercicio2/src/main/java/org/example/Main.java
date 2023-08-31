package org.example;


public class Main {
    public static void main(String[] args) {
        Categoria Categoria1 = new Categoria(1300,1500,0);
        Categoria Categoria2 = new Categoria(2000,2300,0);
        Categoria Categoria3 = new Categoria(0,2800,18);

        Participante participante1 = new Participante("Enzo","Coppet", 40321232, 18, 233332, 31233, "A+");
        Participante participante2 = new Participante("Matias","Rojas", 40321232, 53, 233332, 31233, "A+");
        Participante participante3 = new Participante("Anibal","Moreno", 40321232, 12, 233332, 31233, "A-");
        Participante participante4 = new Participante("Johan","Carbonero", 40321232, 8, 233332, 31233, "B-");
        Participante participante5 = new Participante("Tita","Mattiusi", 40321232, 70, 233332, 31233, "0-");


        //Inscripcion de los participantes a las categorias
        System.out.println("-------------------Prueba inscripcion-------------------");
        Categoria1.inscribir(participante1);
        Categoria1.inscribir(participante2);
        Categoria2.inscribir(participante3);
        Categoria3.inscribir(participante5);
        System.out.println("---------------------------------------------------------");

        //Prueba inscripcion a categoria no valida
        System.out.println("\n-------------------Prueba inscripcion Categoria no valida-------------------");
        Categoria3.inscribir(participante4);
        System.out.println("----------------------------------------------------------------------------");

        Categoria1.inscribir(participante4);

        //Desinscripcion
        System.out.println("\n-------------------Prueba Desinscripcion-------------------");
        Categoria1.desinscribir(participante1);
        System.out.println("------------------------------------------------------------");

        //Inscribir participantes ya inscritos a la misma u otra carrera
        System.out.println("\n-------------------Prueba inscripcion participante ya inscripto -------------------");
        Categoria1.inscribir(participante4);
        Categoria2.inscribir(participante4);
        System.out.println("-----------------------------------------------------------------------------------");

        //Muestro participantes y recaudacion por categorias
        System.out.println("\n------------------- Categoria 1 -------------------");
        Categoria1.mostrarParticipantes();
        System.out.println("------------------- Recaudacion: "+Categoria1.getRecaudacion()+"-------------------");

        System.out.println("\n------------------- Categoria 2 -------------------");
        Categoria2.mostrarParticipantes();
        System.out.println("------------------- Recaudacion: "+Categoria2.getRecaudacion()+"-------------------");


        System.out.println("\n------------------- Categoria 3 -------------------");
        Categoria3.mostrarParticipantes();
        System.out.println("------------------- Recaudacion: "+Categoria3.getRecaudacion()+"-------------------");

        //Vacio las categorias para los ejercicios
        Categoria1.desinscribir(participante2);
        Categoria1.desinscribir(participante4);
        Categoria2.desinscribir(participante3);
        Categoria3.desinscribir(participante5);




        System.out.println("\n\n\n------------------- EJERCICIOS -------------------");
        System.out.println("------------------- B ----------------------------");
        Participante participante6 = new Participante("Alfio","Basile", 40321232, 70, 233332, 31233, "0-");
        Categoria1.inscribir(participante6);


        System.out.println("\n\n\n------------------- C ----------------------------");
        Categoria1.inscribir(participante1);
        Categoria1.inscribir(participante2);
        Categoria2.inscribir(participante3);
        Categoria3.inscribir(participante5);


        System.out.println("\n\n\n------------------- D ----------------------------");
        System.out.println("------------------- categorias -------------------");
        Categoria1.mostrarParticipantes();



        System.out.println("\n\n\n------------------- E ----------------------------");
        Categoria1.desinscribir(participante1);
        System.out.println("------------------- categorias -------------------");
        Categoria1.mostrarParticipantes();


        System.out.println("\n\n\n------------------- F -----------------------------");
        System.out.println("------------------- categoria 1 -------------------");
        System.out.println("------------------- Recaudacion: "+Categoria1.getRecaudacion()+"--------------");
        System.out.println("\n------------------- categoria 2 -------------------");
        System.out.println("------------------- Recaudacion: "+Categoria2.getRecaudacion()+"--------------");
        System.out.println("\n------------------- categoria 3 -------------------");
        System.out.println("------------------- Recaudacion: "+Categoria3.getRecaudacion()+"--------------");


        System.out.println("Fin del Programa");
    }


}



