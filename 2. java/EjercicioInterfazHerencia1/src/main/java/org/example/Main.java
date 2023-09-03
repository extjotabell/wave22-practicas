package org.example;

import org.example.Clases.Basic;
import org.example.Clases.Cobrador;
import org.example.Clases.Ejecutivo;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Basic ClienteBasic = new Basic();
        Ejecutivo ClienteEjecutivo = new Ejecutivo();
        Cobrador ClienteCobrador = new Cobrador();

        System.out.println("---------------------Basic-------------------------");
        //Realizo las Transacciones del cliente Basic
        ClienteBasic.PagarServicio();
        ClienteBasic.retiroDeEfecitvo();
        ClienteBasic.RealizarConsultaDeSaldo();

        System.out.println("\n---------------------Ejecutivo---------------------");
        //Realizp las Transacciones del cliente Ejecutivo
        ClienteEjecutivo.HacerTransferencia();
        ClienteEjecutivo.RealizarDeposito();


        System.out.println("\n---------------------Cobrador----------------------");
        //Realizp las Transacciones del cliente Ejecutivo
        ClienteCobrador.retiroDeEfecitvo();
        ClienteCobrador.RealizarConsultaDeSaldo();



        }
    }