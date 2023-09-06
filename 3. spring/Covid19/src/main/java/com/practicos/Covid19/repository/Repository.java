package com.practicos.Covid19.repository;

import java.util.List;

public interface Repository<T, E> {
    public List<T> findAll();
    public T find(E id);
    public void delete(E id);
    public void add(T obj);
}
