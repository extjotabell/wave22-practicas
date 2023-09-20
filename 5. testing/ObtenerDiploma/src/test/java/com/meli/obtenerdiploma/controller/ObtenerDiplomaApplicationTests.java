package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ObtenerDiplomaWhitOutMockApplicationTests {

	@Autowired
	private IStudentDAO studentDAO;
	@Autowired
	private IObtenerDiplomaService obtenerDiplomaService;

	@Test
	void findById() {
		StudentDTO student = new StudentDTO();
		student.setStudentName("Mati Marin");
		student.setSubjects(List.of(new SubjectDTO("Math", 8.0)));
		double averageExpected = 8.0;

		studentDAO.save(student);
		Long id = student.getId();

		StudentDTO foundStudent = obtenerDiplomaService.analyzeScores(id);

		assertNotNull(foundStudent);
		assertEquals(averageExpected, foundStudent.getAverageScore());
	}

	@Test
	void findByIdThrowsExceptionWhenNotFound() {
		assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(99L));
	}
}