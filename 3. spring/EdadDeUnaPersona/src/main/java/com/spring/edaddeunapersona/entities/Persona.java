package com.spring.edaddeunapersona.entities;

import lombok.Data;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Data
public class Persona {
    private int edad;
    private int mes;
    private int año;

    public int calcularEdad(int dia, int mes, int año){
        Calendar fechaNacimiento = new GregorianCalendar(año, mes, dia);
        Calendar fechaActual = Calendar.getInstance();

        //Calcula diferencias.
        int years = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        int months = fechaActual.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH);
        int days = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNacimiento.get(Calendar.DAY_OF_MONTH);

        if(months < 0 //Aun no es mes de cumpleaños.
                || (months == 0 && days < 0)){//Es el mes pero no ha llegado el día.
            years--; //Se resta 1 a la diferencia de años.
        }
        return years;
    }
}
