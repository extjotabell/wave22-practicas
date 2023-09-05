package org.example.repository;

import java.util.List;

public interface Crud <T>{
    T save(T nuevo);
    void delete(int id);
    List<T> getAll();

}
