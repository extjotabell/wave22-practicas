package com.deportista.deportista.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deporte {
    public int Id;
    public String nombre;
    public String nivel;

    public List<Deporte> GetListDeporte(){
        List<Deporte> deporteList = new ArrayList<>();
        deporteList.add(new Deporte(1,"Futbol","medio"));
        deporteList.add(new Deporte(2,"Voley","dificil"));
        deporteList.add(new Deporte(3,"paddel","facil"));
        return  deporteList;
    }
}
