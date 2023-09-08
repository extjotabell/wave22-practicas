package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.model.Food;

import java.util.List;

public interface IRepo<T,E> {

     List<T> getAll();

     T getByName(E name);

}
