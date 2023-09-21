package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindService {

  @Autowired
  CharacterRepositoryImpl characterRepository;

  public List<CharacterDTO> find(String query) {
    return characterRepository.findAllByNameContains(query);
  }
}
