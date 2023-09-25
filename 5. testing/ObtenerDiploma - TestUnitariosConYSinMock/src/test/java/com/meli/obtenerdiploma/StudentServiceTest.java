package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.exception.StudentsNoFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    StudentDAO studentDao;
    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void create()
    {
        //ARRANGE
        Set<StudentDTO> studentRepo = new HashSet<>();
        StudentDTO newStudent = new StudentDTO((long)80, "Lulu", "Estudiante", 7.75,
                List.of(new SubjectDTO("Matematicas", 7.5),
                        new SubjectDTO("Biologia", 8.0)));

        //ACT
        studentService.create(newStudent);

        //ASSERT
        verify(studentDao, atLeast(1)).save(newStudent);
    }

    @Test
    void findStudentByIdTestOk()
    {
        //ARRANGE
        Set<StudentDTO> studentRepo = new HashSet<>();
        StudentDTO student = new StudentDTO((long)80, "Lulu", "Estudiante", 8.5,
                List.of(new SubjectDTO("Matematicas", 7.5),
                        new SubjectDTO("Biologia", 8.0)));
        studentRepo.add(student);

        //ACT
        when(studentService.read(student.getId())).thenReturn(student);
        StudentDTO actual = studentService.read(student.getId());
        //ASSERT
        assertEquals(student, actual);
    }

    @Test
    void findStudentByIdTestFail()
    {
        //ARRANGE
        Set<StudentDTO> studentRepo = new HashSet<>();
        StudentDTO student = new StudentDTO((long)80, "Lulu", "Estudiante", 7.75,
                List.of(new SubjectDTO("Matematicas", 7.5),
                        new SubjectDTO("Biologia", 8.0)));
        StudentDTO student2 = new StudentDTO((long)100, "martina", "Estudiante", 7.75,
                List.of(new SubjectDTO("Fisica", 6.5),
                        new SubjectDTO("Biologia", 8.0)));
        studentRepo.add(student);

        //ACT
        when(studentDao.findById(student2.getId())).thenThrow(new StudentNotFoundException(student.getId()));

        //ASSERT
        assertThrows(StudentNotFoundException.class, () ->
        {
            studentService.read(student2.getId());
        });
    }

    @Test
    void updateStudentTestOk()
    {
        //ARRANGE
        Set<StudentDTO> studentRepo = new HashSet<>();
        StudentDTO student = new StudentDTO((long)80, "Lulu", "Estudiante", 7.75,
                List.of(new SubjectDTO("Matematicas", 7.5),
                        new SubjectDTO("Biologia", 8.0)));
        studentRepo.add(student);
        student.setStudentName("Pepe");

        //ACT
        studentService.update(student);

        //ASSERT
        verify(studentDao, atLeast(1)).save(student);
    }

    @Test
    void deleteStudentTest()
    {
        //ARRANGE
        Set<StudentDTO> studentRepo = new HashSet<>();
        StudentDTO student = new StudentDTO((long)80, "Lulu", "Estudiante", 7.75,
                List.of(new SubjectDTO("Matematicas", 7.5),
                        new SubjectDTO("Biologia", 8.0)));
        studentRepo.add(student);

        //ACT
        when(studentDao.delete(student.getId())).thenReturn(true);
        studentService.delete(student.getId());
        //ASSERT
        verify(studentDao, atLeast(1)).delete(student.getId());
    }

    @Test
    void getlAllStudentsTestOk()
    {
        //arrange
        Set<StudentDTO> studentsRepo = new HashSet<>();
        StudentDTO student = new StudentDTO((long)80, "Lulu", "Estudiante", 7.75,
                List.of(new SubjectDTO("Matematicas", 7.5),
                        new SubjectDTO("Biologia", 8.0)));

        studentsRepo.add(student);
        when(studentRepository.findAll()).thenReturn(studentsRepo);

        //act
        Set<StudentDTO> actual = studentService.getAll();

        //ASSERT
        assertEquals(studentsRepo, actual);
    }

    @Test
    void getlAllStudentsTestFail()
    {
        //ARRANGE
        Set<StudentDTO> studentsRepo = new HashSet<>();

        //ACT
        when(studentRepository.findAll()).thenThrow(new StudentsNoFoundException());

        //ASSERT
        assertThrows(StudentsNoFoundException.class, () ->
                {
                    studentService.getAll();
                });
    }
}
