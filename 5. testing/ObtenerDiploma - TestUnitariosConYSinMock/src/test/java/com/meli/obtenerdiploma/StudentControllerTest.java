package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.exception.StudentsNoFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    StudentService studentService;
    StudentDAO studentDao;

    @InjectMocks
    StudentController studentController;

    @Test
    void registerStudentTestOk()
    {
        //ARRANGE
        StudentDTO newStudent = new StudentDTO((long) 10, null, null, null, List.of(new SubjectDTO("Matematicas", 7.5),
                new SubjectDTO("Biologia", 8.0)));

        //ACT
        studentController.registerStudent(newStudent);

        //ASSERT
        verify(studentService, atLeast(1)).create(newStudent);
    }

    @Test
    void modifyStudentTestOk()
    {
        //ARRANGE
        StudentDTO student = new StudentDTO((long)80, "Lulu", "Estudiante", null,
                List.of(new SubjectDTO("Matematicas", 7.5),
                        new SubjectDTO("Biologia", 8.0)));

        //ACT
        studentController.modifyStudent(student);

        //ASSERT
        verify(studentService, atLeast(1)).update(student);
    }

    @Test
    void removeStudentTestOk()
    {
        //ARRANGE
        StudentDTO student = new StudentDTO((long)80, "Lulu", "Estudiante", null,
                List.of(new SubjectDTO("Matematicas", 7.5),
                        new SubjectDTO("Biologia", 8.0)));

        //ACT
        studentController.removeStudent(student.getId());

        //ASSERT
        verify(studentService, atLeast(1)).delete(student.getId());
    }

    @Test
    void getStudentTestOk()
    {
        //ARRANGE
        StudentDTO student = new StudentDTO((long)80, "Lulu", "Estudiante", null,
                List.of(new SubjectDTO("Matematicas", 7.5),
                        new SubjectDTO("Biologia", 8.0)));

        //ACT
        when(studentService.read(student.getId())).thenReturn(student);
        StudentDTO expected = studentService.read(student.getId());
        studentController.getStudent(student.getId());

        //ASSERT
        assertEquals(expected, student);
    }

    @Test
    void getAllStudentsTestOk()
    {
        //ARRANGE
        Set<StudentDTO> studentList = new HashSet<>();
        studentList.add(new StudentDTO((long)80, "Lulu", "Estudiante", null,
                List.of(new SubjectDTO("Matematicas", 7.5),
                        new SubjectDTO("Biologia", 8.0))));
        studentList.add( new StudentDTO((long)100, "Manuel", "Estudiante", null,
                List.of(new SubjectDTO("Literatura", 7.5),
                        new SubjectDTO("Biologia", 5.0))));

        //ACT
        when(studentService.getAll()).thenReturn(studentList);
        Set<StudentDTO> expected = new HashSet<>();
        expected = studentService.getAll();

        //ASSERT
        assertEquals(expected, studentList);
    }

    @Test
    void getAllStudentsTestFailEmpty()
    {
        //ARRANGE
        Set<StudentDTO> expected = new HashSet<>();

        //ACT
        when(studentService.getAll()).thenThrow(new StudentsNoFoundException());

        //ASSERT
        assertThrows(StudentsNoFoundException.class, () ->
        {
            studentService.getAll();
        });
    }
}
