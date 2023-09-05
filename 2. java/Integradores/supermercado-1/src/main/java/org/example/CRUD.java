package org.example;

import java.util.Set;

public interface CRUD <T, ID>{
    void save(T entity);

    void delete(ID id);

    T update(T entity);

    T findById(ID id);

    void printAll();
}
