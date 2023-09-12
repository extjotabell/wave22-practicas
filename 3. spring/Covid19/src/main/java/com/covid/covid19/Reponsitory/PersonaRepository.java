package com.covid.covid19.Reponsitory;

import com.covid.covid19.Entity.Persona;
import com.covid.covid19.Entity.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonaRepository implements  IPersonaRepository{

    List<Sintoma> sintomaList = new ArrayList<>();
    List<Persona> personaList = new ArrayList<>();
    public PersonaRepository(){
        Sintoma sintoma1 = new Sintoma (1,"gripe","leve");
        Sintoma sintoma2 = new Sintoma (2,"neumonia","medio");
        Sintoma sintoma3 = new Sintoma (3,"covid","grave");
        sintomaList.add(sintoma1);
        sintomaList.add(sintoma2);
        sintomaList.add(sintoma3);
        List<Sintoma> sintomaList1 = new ArrayList<>();
        sintomaList1.add(sintoma1);
        sintomaList1.add(sintoma3);
        List<Sintoma> sintomaList2 = new ArrayList<>();
        sintomaList2.add(sintoma2);
        personaList.add(new Persona(1,"solange","recayte",63,sintomaList1));
        personaList.add(new Persona(2,"Daniel","Fimiani",65,sintomaList2));
    }
    @Override
    public List<Sintoma> AllSintoma() {
        return this.sintomaList;
    }

    @Override
    public Sintoma GetSintoma(String name) {
        return this.sintomaList.stream().filter(x->x.getNombre().equals(name)).findFirst().get();
    }

    @Override
    public List<Persona> GetPersona() {
        List<Persona> personasCritica = new ArrayList<>();
        for(Persona persona : this.personaList){
            if(persona.getEdad()>=60){
                for (Sintoma sintoma : persona.getSintomaList()){
                    if(sintoma.getNivelDegravedad().equals("grave")){
                        personasCritica.add(persona);
                        break;
                    }
                }
            }
        }
        return personasCritica;
    }
}
