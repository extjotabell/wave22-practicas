package com.example.covid_19.service;

import com.example.covid_19.dto.GravedadDTO;
import com.example.covid_19.dto.SintomaDTO;
import com.example.covid_19.dto.SintomasDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements IService{

    SintomasDTO sintomas = new SintomasDTO();

    public ServiceImpl() {
        SintomaDTO fiebre = new SintomaDTO();
        fiebre.setCodigo("863");
        fiebre.setNombre("fiebre");
        fiebre.setNivel_de_gravedad(2);
        SintomaDTO dolor = new SintomaDTO();
        dolor.setNombre("dolor muscular");
        dolor.setNivel_de_gravedad(4);
        dolor.setCodigo("667");
        this.sintomas.agregarSintomas(fiebre);
        this.sintomas.agregarSintomas(dolor);
    }

    public List<SintomaDTO> getSintomas(){
        return this.sintomas.getListaSintomas();
    }

    @Override
    public GravedadDTO obtenerGravedadSintoma(SintomaDTO sintoma_buscado) {
        for (SintomaDTO sintoma : this.sintomas.getListaSintomas()){
            if (sintoma.getNombre().equals(sintoma_buscado.getNombre())){
                GravedadDTO gravedad = new GravedadDTO();
                gravedad.setGravedad_sintoma(sintoma.getNivel_de_gravedad());
                return gravedad;
            }
        }
        // si no se encuentra retorna null
        return null;
    }

    public void setSintomas(SintomasDTO sintomas) {
        this.sintomas = sintomas;
    }
}
