package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ObetenerDiplomaApplicationTests {

	@Autowired
	StudentDAO studentDAO;



	@Test
	public void saveStudent() {
		//Arrange
		List<SubjectDTO> subjectDTOList = new ArrayList<>();
		subjectDTOList.add(new SubjectDTO("Ciencias", 8.0));
		StudentDTO student = new StudentDTO(10L ,"Ale", "hola", 8.5, subjectDTOList);
		int expectedSize = 0;

		//Action
		studentDAO.save(student);
		expectedSize = studentDAO.getStudents().size();

		//Assert
		assertEquals(expectedSize,studentDAO.getStudents().size());
	}

	@Test
	void deleteStudentOK(){
		//Arrange
		Long id = 1L;

		//Act
		boolean actual = studentDAO.delete(id);

		//Assert
		assertTrue(actual);
	}
	@Test
	void deleteStudentError(){
		//Arrange
		Long id = 99L;

		//Act
		//Mockito.when()when(studentDAO.delete(id))

		//Assert
		 //assertThrows(StudentNotFoundException.class,()->);
		assertThrows(StudentNotFoundException.class,()->studentDAO.delete(id));
	}


	@Test
	public void findStudentById(){
		//Arrange
		List<SubjectDTO> subjectDTOList = new ArrayList<>();
		subjectDTOList.add(new SubjectDTO("lengua",6.5));
		StudentDTO student = new StudentDTO(10L ,"Ale", "hola", 8.5, subjectDTOList);
		studentDAO.save(student);

		//Act
		StudentDTO studentFound = studentDAO.findById(student.getId());

		//Assert
		assertEquals(student, studentFound);
	}




	@Test
	public void ModificarDatosAlumno(){
		//Arrange
		List<SubjectDTO> subjectDTOList = new ArrayList<>();
		subjectDTOList.add(new SubjectDTO("matematica", 8.0));
		StudentDTO student = new StudentDTO(3L ,"Valen", "no se", 8.5, subjectDTOList);
		int expectedSize = 0;

		//Action
		studentDAO.save(student);
		expectedSize = studentDAO.getStudents().size();

		//Assert
		assertEquals(expectedSize,studentDAO.getStudents().size());
	}
}