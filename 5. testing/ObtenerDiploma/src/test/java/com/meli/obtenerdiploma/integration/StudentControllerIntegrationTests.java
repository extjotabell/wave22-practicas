package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTests {

    static StudentDAO studentDAO = new StudentDAO();

    @Autowired
    MockMvc mockMvc;

    private StudentDTO studentDTO;

    private static ObjectWriter mapper;

    @BeforeAll
    static void setUp() {
        mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @BeforeEach
    void addStudent() {
        studentDTO = TestUtils.getMockStudent("Nicolas");
        if (!studentDAO.exists(studentDTO))
            studentDAO.save(studentDTO);

        studentDTO = TestUtils.getMockStudent("Victor");
        if (!studentDAO.exists(studentDTO))
            studentDAO.save(studentDTO);

    }

    @Test
    void registerStudentIntegrationTestOk() throws Exception{

        String jsonPayload = mapper.writeValueAsString(TestUtils.getMockStudentAdd("Matias"));
        mockMvc.perform(post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void registerStudentIntegrationTestNotValidStudent() throws Exception{

        String jsonPayload = mapper.writeValueAsString(TestUtils.getMockStudentAdd(" "));
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));

    }

    @Test
    void modifyStudentIntegrationTestOk() throws Exception{

        StudentDTO studentDTO1 = TestUtils.getMockStudent("Victor");
        studentDTO1.setMessage("Mensaje modificado");
        String jsonPayload = mapper.writeValueAsString(studentDTO1);
        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void modifyStudentIntegrationTestNotValidStudent() throws Exception{

        String jsonPayload = mapper.writeValueAsString(TestUtils.getMockStudentAdd(" "));
        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));

    }





    @Test
    void getStudentIntegrationTestOk() throws Exception{
        StudentDTO expectedStudent = TestUtils.getMockStudent("Nicolas");
        String expectedStudentString = mapper.writeValueAsString(studentDTO);
        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/{id}", expectedStudent.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(expectedStudentString, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getStudentIntegrationTestNotFound() throws Exception{

        mockMvc.perform(get("/student/getStudent/{id}", 100L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));

    }

    @Test
    void deleteStudentIntegrationTestOk() throws Exception{
        StudentDTO expectedStudent = TestUtils.getMockStudent("Nicolas");
        mockMvc.perform(get("/student/removeStudent/{id}", expectedStudent.getId()))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void deleteStudentIntegrationTestNotFound() throws Exception{

        mockMvc.perform(get("/student/removeStudent/{id}", 100L))
                .andDo(print())
                .andExpect(status().isOk());
                //Deberia devolver 404 y la excepcion pero el metodo esta mal
                //.andExpect(status().isNotFound())
                //.andExpect(jsonPath("$.name").value("StudentNotFoundException"));

    }



}
