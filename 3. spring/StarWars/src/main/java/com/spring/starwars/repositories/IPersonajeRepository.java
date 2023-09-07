package com.spring.starwars.repositories;

import com.spring.starwars.entities.Personaje;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findPersonajesByWord(String word);
}
