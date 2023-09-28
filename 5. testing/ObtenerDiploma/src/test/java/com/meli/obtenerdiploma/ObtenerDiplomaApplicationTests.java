package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Data
class ObetenerDiplomaApplicationTests {

	@Autowired
	IStudentDAO studentDAORepository;

	@Test
	@DisplayName("findbyIdTest - Buscar StudentDTO por id")
	public void findByIdTest() {

		List<SubjectDTO> subjects = new ArrayList<>();

		double score = 9;
		SubjectDTO subject = new SubjectDTO("Matemática", score);
		subjects.add(subject);

		score = 7;
		subject = new SubjectDTO("Física", score);
		subjects.add(subject);

		score = 6;
		subject = new SubjectDTO("Química", score);
		subjects.add(subject);

		StudentDTO expectedDTO = new StudentDTO();
		expectedDTO.setId(1L);
		expectedDTO.setStudentName("Juan");
		expectedDTO.setSubjects(subjects);

		// Act
		StudentDTO result = studentDAORepository.findById(1L);

		System.out.println(expectedDTO);
		System.out.println(result);

		// Assert
		Assertions.assertEquals(expectedDTO, result);
		//Assertions.assertEquals(expectedDTO.getId(), result.getId());
		//Assertions.assertEquals(expectedDTO.getSubjects().get(0).getName(), result.getSubjects().get(0).getName());
	}

	@Test
	public void saveTest(){
		// Generar estudiante
		List<SubjectDTO> subjects = new ArrayList<>();

		double score = 9;
		SubjectDTO subject = new SubjectDTO("Matemática", score);
		subjects.add(subject);

		score = 7;
		subject = new SubjectDTO("Física", score);
		subjects.add(subject);

		score = 6;
		subject = new SubjectDTO("Química", score);
		subjects.add(subject);

		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Juan");
		studentDTO.setSubjects(subjects);

		// Act
		Assertions.assertEquals(1, 1);

	}
}