package com.meli.obtenerdiploma.integral;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.testUtils.ObjectWriterMapperUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static com.meli.obtenerdiploma.testUtils.FileCopier.copyFiles;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.File;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Abb {

    @BeforeEach
    void init() {
        try {
            copyFiles(new File("./src/test/resources/usersOriginal.json"), new File("./src/test/resources/users.json"));
        } catch (Exception e) {
            System.out.println("Ups " + e.getMessage());
        }
    }

    @Autowired
    MockMvc mockMvc;

    //Student
    @Test
    void getStudentOkTest() throws Exception {
        Object obj = null; // No nos dejaba poner null directamente

        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/2"))
            .andDo(print())
                .andExpect(status().isOk())
            .andExpect(jsonPath("$.studentName")
                .value("Pedro"))
            .andExpect(jsonPath("$.averageScore")
                .value(obj))
            .andReturn();
    }

    @Test
    void getStudentNotFoundFailTest() throws Exception{
        MvcResult result = mockMvc.perform(get("/student/getStudent/1000"))
            .andDo(print())
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.name")
                .value("StudentNotFoundException"))
            .andExpect(jsonPath("$.description")
                .value("El alumno con Id " + 1000 + " no se encuetra registrado."))
            .andReturn();
    }

    @Test
    void getNoStudentFailTest() throws Exception{
        MvcResult result = mockMvc.perform(get("/student/getStudent/"))
            .andDo(print())
            .andExpect(status().isNotFound())
            .andReturn();
    }

    @Test
    void removeStudentOkTest() throws Exception {

        MvcResult result = mockMvc.perform(get("/student/removeStudent/1"))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
    }
    //nunca falla, sobrescribe el existente
    //void removeStudentFailTest() throws Exception

    @Test
    void registerStudentOkTest() throws Exception
    {
        SubjectDTO subject = new SubjectDTO("Matematicas", 8.0);
        StudentDTO newStudent = new StudentDTO((long)100, "Luciana", "Mensaje", null, List.of(
                subject
        ));

        String jsonPayload = ObjectWriterMapperUtil.convertJsonPayload(newStudent);

        MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andDo(print()).
                andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void registerStudentFailTest() throws Exception
    {
        SubjectDTO subject = new SubjectDTO("Matematicas", 8.0);
        StudentDTO newStudent = new StudentDTO((long)1200, null, "Mensaje", null, List.of(subject));


        String jsonPayload = ObjectWriterMapperUtil.convertJsonPayload(newStudent);
        ErrorDTO error = new ErrorDTO(MethodArgumentNotValidException.class.getSimpleName(),"El nombre del estudiante no puede estar vacÃ\u00ADo.");
        String errorExpected = ObjectWriterMapperUtil.convertJsonPayload(error);

        MvcResult result = mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andDo(print())
                .andReturn();
        assertEquals(errorExpected, result.getResponse().getContentAsString());
    }

    @Test
    void modifyStudendOkTest() throws Exception{
        StudentDTO student = new StudentDTO((long)100, "Luciana", "Se cambia mensaje", null, List.of(new SubjectDTO("Matematicas", 8.0)));

        String jsonPayload = ObjectWriterMapperUtil.convertJsonPayload(student);

        MvcResult result = mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                        .andDo(print())
                        .andReturn();
    }

    //ObtenerDiploma
    @Test
    void analyzeScoresOkTest() throws Exception
    {
        MvcResult result = mockMvc.perform(get("/analyzeScores/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").
                        value(2))
                .andExpect(jsonPath("$.message")
                        .value("El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar."))
                .andReturn();
    }

    @Test
    void analyzeScoresFailTest() throws Exception
    {
        MvcResult result = mockMvc.perform(get("/analyzeScores/200")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").
                        value("El alumno con Id 200 no se encuetra registrado."))
                .andExpect(jsonPath("$.name").
                        value(StudentNotFoundException.class.getSimpleName()))
                .andReturn();
    }
}
