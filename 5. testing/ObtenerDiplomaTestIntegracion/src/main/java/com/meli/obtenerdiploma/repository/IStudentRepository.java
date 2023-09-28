package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public interface IStudentRepository {

    Set<StudentDTO> findAll() throws IOException;

}
