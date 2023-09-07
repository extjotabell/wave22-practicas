package com.example.covid19.services;

import com.example.covid19.models.Sintoma;
import com.example.covid19.web.dto.SintomaDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SintomaServicesImp implements SintomaServices{

    List<Sintoma> sintomas;

    public SintomaServicesImp(){
        Sintoma sintoma1= new Sintoma(1,"mareo","bajo");
        Sintoma sintoma2= new Sintoma(2,"dolor de cabeza","grave");
        Sintoma sintoma3= new Sintoma(3,"vomito","grave");
        Sintoma sintoma4= new Sintoma(4,"fiebre","intermedio");

        this.sintomas = Arrays.asList(sintoma1,sintoma2,sintoma3,sintoma4);

    }
    @Override
    public List<SintomaDTO> findSymptom() {

        List<SintomaDTO> sintomasDTO;
        sintomasDTO = sintomas.stream().map(sintoma -> {
            String nombre = sintoma.getNombre();
            String nivel = sintoma.getNivel_de_gravedad();
            return new SintomaDTO(nombre, nivel);
        }).collect(Collectors.toList());
        return sintomasDTO;
    }

    @Override
    public Sintoma findSymptomByName(String name) {
        Sintoma sintomaEncontrado = null;
        for (Sintoma s : sintomas) {
            if(Objects.equals(s.getNombre(), name)) {
                sintomaEncontrado = s;
                return  sintomaEncontrado;
            }
        }
        System.out.println("No se ha encontrado el sintoma");
        return  sintomaEncontrado;
    }
    }

