package com.example.relacionesjpa.service;

import com.example.relacionesjpa.dto.ManyToMany.StudentDTO;
import com.example.relacionesjpa.entity.ManyToMany.Course;
import com.example.relacionesjpa.entity.ManyToMany.StudentManyToMany;
import com.example.relacionesjpa.repository.CourseRepository;
import com.example.relacionesjpa.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements StudentService{

    private final StudentRepository stuRepo;
    private final CourseRepository courseRepository;
    ModelMapper mapper;

    public StudentServiceImp(StudentRepository stuRepo, CourseRepository courseRepository) {
        this.stuRepo = stuRepo;
        this.courseRepository = courseRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public String guardar(StudentDTO stu) {
        StudentManyToMany student = mapper.map(stu, StudentManyToMany.class);
        Set<Course> courseSet = stu.getLinkedCourses().stream().map(s-> mapper.map(s, Course.class)).collect(Collectors.toSet());
        student.setLinkedCourses(courseSet);
        stuRepo.save(student);
        return "Guardado con exito";
    }
}
