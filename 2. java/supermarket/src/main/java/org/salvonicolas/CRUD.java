package org.salvonicolas;

import java.util.List;

public interface CRUD<T> {
    public void remove(T element);
    public void add(T element);
    public List<T> getAll();
    public T get(int index);
    public void print();
}
