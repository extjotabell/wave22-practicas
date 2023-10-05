package crudExample.crudExample.service;

import crudExample.crudExample.model.Student;
import crudExample.crudExample.repository.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    private final IStudentRepository repository;

    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        repository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Student updateStudent(long id, String newName, String newLastName) {
        Student student = findStudent(id);
        student.setName(newName);
        student.setLastname(newLastName);
        saveStudent(student);
        return student;
    }
}
