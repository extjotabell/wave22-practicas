package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.FileWriter;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {
    static StudentDTO studentDTO;
    @BeforeAll
    static void setup(){
        List<SubjectDTO> listSubject = List.of(new SubjectDTO("Lengua",10.0), new SubjectDTO("Fisica",8.0), new SubjectDTO("Quimica",4.0));
        studentDTO = new StudentDTO(1L,"Pedro",null,null,listSubject);
    }

    ObjectWriter mapper = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void registerStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.registerStudent(stu);

        // assert
        verify(service, atLeastOnce()).create(stu);
    }
    
    @Test
    public void getStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(service.read(stu.getId())).thenReturn(stu);

        // act
        StudentDTO readStu = controller.getStudent(stu.getId());

        // assert
        verify(service, atLeastOnce()).read(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    public void modifyStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.modifyStudent(stu);

        // assert
        verify(service, atLeastOnce()).update(stu);
    }

    @Test
    public void removeStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.removeStudent(stu.getId());

        // assert
        verify(service, atLeastOnce()).delete(stu.getId());
    }

    @Test
    public void listStudents() {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        when(service.getAll()).thenReturn(students);

        // act
        Set<StudentDTO> readStudents = controller.listStudents();

        // assert
        verify(service, atLeastOnce()).getAll();
        //assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }

    @Test
    void registerStudentIntegrationOk() throws Exception{
        String payload = mapper.writeValueAsString(studentDTO);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getStudentIntegrationOk() throws Exception{

        String expected = mapper.writeValueAsString(studentDTO);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(expected,mvcResult.getResponse().getContentAsString());
    }

    @Test
    void modifyStudentIntegrationOk() throws Exception{
        String payload = mapper.writeValueAsString(studentDTO);

        mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void removeStudentIntegrationOk() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}","1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void listStudentsIntegrationOk() throws Exception{

        Set<StudentDTO> expectedSet = Set.of(studentDTO);
        String expected = mapper.writeValueAsString(expectedSet);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andReturn();

        Assertions.assertEquals(expected,mvcResult.getResponse().getContentAsString());
    }

}
