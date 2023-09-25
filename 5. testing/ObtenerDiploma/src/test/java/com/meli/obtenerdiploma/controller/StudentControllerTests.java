package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {

    @Mock
    private StudentService service;

    @InjectMocks
    private StudentController controller;

    @Test
    void registerStudentTest() {
        StudentDTO studentDTO = TestUtils.getMockStudent("Juan");

        controller.registerStudent(studentDTO);

        verify(service, atLeastOnce()).create(studentDTO);
    }

    @Test
    void modifyStudentTest() {
        StudentDTO studentDTO = TestUtils.getMockStudent("Juan");

        controller.modifyStudent(studentDTO);

        verify(service, atLeastOnce()).update(studentDTO);
    }

    @Test
    void removeStudentTest() {
        StudentDTO studentDTO = TestUtils.getMockStudent("Juan");

        controller.removeStudent(studentDTO.getId());

        verify(service, atLeastOnce()).delete(studentDTO.getId());
    }

    @Test
    void listStudentsTest() {
        controller.listStudents();

        verify(service, atLeastOnce()).getAll();
    }
}
