package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.integration.utils.ObjectFactory;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ITStudentController {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    IStudentService studentService;
    private static ObjectMapper mapper;
    private static ObjectWriter writer;
    StudentDTO studentDTO;
    static ObjectFactory objectFactory;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        mapper = new ObjectMapper();
        objectFactory = new ObjectFactory();
    }

    @BeforeEach
    void beforeEach() {
        studentDTO = objectFactory.studentDTOProvider();
    }

    @Test
    @DisplayName("1- Register Student OK case")
    void registerStudent_test_OK() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("2- GetStudent OK Case")
    void getStudent_test_ok() throws Exception {
        Mockito.when(studentService.read(1L)).thenReturn(studentDTO);
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", studentDTO.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String jsonResponse = result.getResponse().getContentAsString();
        StudentDTO response = mapper.readValue(jsonResponse, StudentDTO.class);
        assertNotNull(response);
        assertEquals("Name", response.getStudentName());
    }

    @Test
    @DisplayName("3- ModifyStudent OK Test")
    void modifyStudent_test_ok() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("4- RemoveStudent OK Case")
    void removeStudent_test_ok() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", studentDTO.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("5- List Students OK Case")
    void listStudents_test_ok() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
