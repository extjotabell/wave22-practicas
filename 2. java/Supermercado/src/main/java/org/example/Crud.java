package org.example;

import java.util.List;
import java.util.Optional;

public interface Crud<T> {
    public void create (T obj);
    public Optional<T> read (String id);
    public void update (T obj);
    public void delete (String id);
    public List<T> getAll();
}
