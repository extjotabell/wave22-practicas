package com.startWars.startWars.repository;

import com.startWars.startWars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> buscarPorNombre(String nombre);
}
