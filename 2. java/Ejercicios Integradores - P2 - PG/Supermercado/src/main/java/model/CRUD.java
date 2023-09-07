package model;

import java.util.List;

public interface CRUD<T> {

    void create(T t);

    void delete(int id);

    void update(int id, T newObj);

    T getObjectById(int id);

    List<T> getAll();
}
