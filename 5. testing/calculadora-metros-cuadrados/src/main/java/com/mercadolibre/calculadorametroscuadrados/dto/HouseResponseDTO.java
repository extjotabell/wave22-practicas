package com.mercadolibre.calculadorametroscuadrados.dto;

import java.util.Objects;

public class HouseResponseDTO extends HouseDTO {
  private Integer squareFeet;
  private Integer price;
  private RoomDTO biggest;

  public HouseResponseDTO() {
  }

  public HouseResponseDTO(HouseDTO house) {
    super(house.getName(), house.getAddress(), house.getRooms());
  }

  public Integer getSquareFeet() {
    return squareFeet;
  }

  public void setSquareFeet(Integer squareFeet) {
    this.squareFeet = squareFeet;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public RoomDTO getBiggest() {
    return biggest;
  }

  public void setBiggest(RoomDTO biggest) {
    this.biggest = biggest;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    HouseResponseDTO that = (HouseResponseDTO) o;
    return Objects.equals(super.getName(), that.getName()) &&
            Objects.equals(super.getAddress(), that.getAddress()) &&
            Objects.equals(super.getRooms(), that.getRooms());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.getName(), super.getAddress(), super.getRooms());
  }
}
