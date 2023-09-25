package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentDAO studentDAO;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    StudentService service;


    //Agregar un alumno.
    @Test
    public void addStudenTest(){
        StudentDTO studentDTO = new StudentDTO(4L,"jorge","",0.0, List.of(new SubjectDTO("matematica",7.9),new SubjectDTO("lengua",6.0)));
        service.create(studentDTO);
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }
    //Buscar un alumno por Id.
    @Test
    public void getStudenByIdTest(){
        StudentDTO studentDTO = new StudentDTO(4L,"jorge","",0.0, List.of(new SubjectDTO("matematica",7.9),new SubjectDTO("lengua",6.0)));

        when(studentDAO.findById(studentDTO.getId())).thenReturn (studentDTO);
        StudentDTO dto = service.read(studentDTO.getId());
        Assertions.assertEquals(studentDTO,dto);
    }
    //Modificar los datos de un alumno.
    @Test
    public void updateStuden(){
        StudentDTO Updatestudent =  new StudentDTO(4L,"alicia","oks",0.0, List.of(new SubjectDTO("matematica",7.9),new SubjectDTO("lengua",6.0)));
        service.update(Updatestudent);
        verify(studentDAO, atLeastOnce()).save(Updatestudent);
    }
    //Eliminar un alumno.
    @Test
    public void deleteStuden(){
        long id = 3;
        service.delete(id);
        verify(studentDAO, atLeastOnce()).delete(id);
    }



}
