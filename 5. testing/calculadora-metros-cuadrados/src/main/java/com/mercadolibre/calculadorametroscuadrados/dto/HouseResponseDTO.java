package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode(callSuper = true)
@Data
public class HouseResponseDTO extends HouseDTO {
  private Integer squareFeet;
  private Integer price;
  private RoomDTO biggest;

  public HouseResponseDTO() {
  }

  public HouseResponseDTO(String name, String address, List<RoomDTO> rooms, Integer squareFeet, Integer price, RoomDTO biggest) {
    super(name, address, rooms);
    this.squareFeet = squareFeet;
    this.price = price;
    this.biggest = biggest;
  }

  public HouseResponseDTO(Integer squareFeet, Integer price, RoomDTO biggest) {
    this.squareFeet = squareFeet;
    this.price = price;
    this.biggest = biggest;
  }

  public HouseResponseDTO(HouseDTO house) {
    this.setName(house.getName());
    this.setAddress(house.getAddress());
    this.setRooms(house.getRooms());
  }

  public void setSquareFeet(Integer squareFeet) {
    this.squareFeet = squareFeet;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public void setBiggest(RoomDTO biggest) {
    this.biggest = biggest;
  }
}
