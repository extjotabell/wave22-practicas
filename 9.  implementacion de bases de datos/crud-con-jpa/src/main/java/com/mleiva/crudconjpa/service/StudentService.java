package com.mleiva.crudconjpa.service;

import com.mleiva.crudconjpa.model.Student;
import com.mleiva.crudconjpa.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(Student stu) {
        repository.save(stu);
    }

    @Override
    @Transactional
    public void deleStudent(long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(long id) {
        return repository.findById(id).orElse(null);
    }
}
