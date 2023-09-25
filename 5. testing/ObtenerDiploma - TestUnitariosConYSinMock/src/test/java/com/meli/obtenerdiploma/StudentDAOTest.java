package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOTest {
    StudentDAO studentDAO = new StudentDAO();
    StudentRepository studentRepository = new StudentRepository();
    @Test
    void createNewStudentTestOk()
    {
        //ARRANGE
        StudentDTO student = new StudentDTO((long)80, "Lulu", "Estudiante", null,
                List.of(new SubjectDTO("Matematicas", 7.5),
                        new SubjectDTO("Biologia", 8.0)));

        //ACT
        studentDAO.save(student);

        //ASSERT
        assertNotNull(studentDAO.findById(student.getId()));
    }

    @Test
    //ver despues
    void createNewStudentTestFail()
    {
        //ARRANGE
        StudentDTO student = new StudentDTO(null, null, null, null, null);

        //studentDAO.save(student);
        assertThrows(null, () -> studentDAO.save(student));
    }
    @Test
    void findStudentByIdTestOk()
    {
        //ARRANGE
        StudentDTO student = new StudentDTO((long)2, "Pedro", null, null,
                List.of(new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0)));
        studentDAO.save(student);

        //ACT
        StudentDTO expected = studentDAO.findById((long)2);

        //ASSERT
        assertEquals(expected,student);
    }

    @Test
    void findStudentByIdTestFail()
    {
        //ARRANGE
        StudentDTO student = new StudentDTO((long)90, "Pedro", null, null,
                List.of(new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0)));

        // ACT AND ASSERT
        assertThrows(StudentNotFoundException.class,  () -> {
            studentDAO.findById((long)student.getId());
        } );
    }

    @Test
    void findAllStudentsTestOk()
    {
        //ARRANGE
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO((long)1, "Lulu", "Estudiante", null,
                List.of(new SubjectDTO("Matematicas", 7.5)
                )));
        Set<StudentDTO> expectedStudents = new HashSet<>();


        //ACT
        expectedStudents = studentRepository.findAll();

        //ASSERT
        assertEquals(expectedStudents, students);
    }

    @Test
    void delete()
    {
        //ARRANGE
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO((long)1, "Lulu", "Estudiante", null,
                List.of(new SubjectDTO("Matematicas", 7.5)
                )));
        Set<StudentDTO> expectedStudents = new HashSet<>();


        //ACT
        Boolean eliminar = studentDAO.delete((long)1);

        assertEquals(true, eliminar);
    }
}
