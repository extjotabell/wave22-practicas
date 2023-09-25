package com.mercadolibre.calculadorametroscuadrados.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Data
public class HouseDTO {
  private String name;
  private String address;
  private List<RoomDTO> rooms;

  public HouseDTO() {

  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setRooms(List<RoomDTO> rooms) {
    this.rooms = rooms;
  }
}
