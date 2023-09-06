package com.example.covid19.repository;

import com.example.covid19.model.Sintoma;

import java.util.ArrayList;
import java.util.List;

public interface InterfaceCRUD<T> {

    void save(T objeto);

}
