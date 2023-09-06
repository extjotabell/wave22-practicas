package com.spring.covid19.services.impl;

import com.spring.covid19.entities.Gravedad;
import com.spring.covid19.entities.Sintoma;
import com.spring.covid19.services.SintomaService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class SintomaServiceImpl implements SintomaService {

    private List<Sintoma> sintomas;
    public SintomaServiceImpl(){
        Sintoma s1 = new Sintoma("A001", "Dolor de cabeza", Gravedad.MEDIA);
        Sintoma s2 = new Sintoma("B002", "Nausea", Gravedad.BAJA);
        Sintoma s3 = new Sintoma("Z203", "Perdida de olfato", Gravedad.BAJA);
        Sintoma s4 = new Sintoma("XR09", "Escalofrios", Gravedad.MEDIA);
        Sintoma s5 = new Sintoma("MN04", "Convulsion", Gravedad.ALTA);
        this.sintomas = Arrays.asList(s1, s2, s3, s4, s5);
    }

    @Override
    public List<Sintoma> findAllSintomas() {
        return sintomas;
    }

    @Override
    public Sintoma findSintomaByName(String name) {
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
