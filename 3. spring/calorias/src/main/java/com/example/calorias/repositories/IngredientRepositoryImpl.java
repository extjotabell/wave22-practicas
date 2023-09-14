package com.example.calorias.repositories;


import com.example.calorias.dto.IngredienteDTO;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {
  private List<IngredienteDTO> database;

  public IngredientRepositoryImpl() {
    database = loadDataBase();
  }

  @Override
  public IngredienteDTO findIngredientByName(String name) {
    Optional<IngredienteDTO> first = database.stream().filter(IngredienteDTO -> IngredienteDTO.getName().equals(name)).findFirst();
    IngredienteDTO result = null;
    if (first.isPresent())
      result = first.get();
    return result;
  }

  private List<IngredienteDTO> loadDataBase() {
    File file = null;
    try {
      file = ResourceUtils.getFile("classpath:food.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<List<IngredientDTO>> typeRef = new TypeReference<>() {};
    List<IngredientDTO> priceDTOS = null;
    try {
      priceDTOS = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return priceDTOS;
  }
}
