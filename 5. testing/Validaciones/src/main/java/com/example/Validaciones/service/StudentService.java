package com.example.Validaciones.service;

import com.example.Validaciones.dto.request.StudentDTO;
import com.example.Validaciones.dto.response.StudentResponseDTO;
import com.example.Validaciones.entity.Student;
import com.example.Validaciones.entity.Subject;
import com.example.Validaciones.exception.BadRequestException;
import com.example.Validaciones.exception.NotFoundException;
import com.example.Validaciones.repo.IStudentRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService{
    IStudentRepo studentRepo;
    ObjectMapper mapper;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        Student student = mapper.convertValue(studentDTO, Student.class);
        studentRepo.save(student);
        studentDTO.setId(student.getId());
        return studentDTO;
    }

    @Override
    public String delete(int id) {
        if(studentRepo.findById(id) == null)
            throw new NotFoundException("There's no Student for id:" + id);
        if(!studentRepo.delete(id))
            throw new BadRequestException("Something went wrong, check that your id is a number");
        return "User with id "+id+ " deleted correctly";
    }

    @Override
    public StudentResponseDTO getStudentByID(int id) {
        Student student = studentRepo.findById(id);
        double average = calculateAverage(student);
        StudentResponseDTO responseDTO = mapper.convertValue(student, StudentResponseDTO.class);
        responseDTO.setAverageScore(average);
        responseDTO.setMessage("El alumno "+responseDTO.getStudentName()+" ha obtenido un promedio de "+average);

        return responseDTO;
    }
    private double calculateAverage(Student student){
        return student.getSubjects().stream().mapToDouble(Subject::getScore).average().orElse(0.0);

    }
}
