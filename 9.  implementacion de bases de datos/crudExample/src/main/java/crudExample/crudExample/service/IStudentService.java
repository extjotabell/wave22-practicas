package crudExample.crudExample.service;

import crudExample.crudExample.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> getStudents();
    public void saveStudent(Student student);
    public void deleteStudent(long id);
    public Student findStudent(long id);
    public Student updateStudent(long id, String newName, String newLastName);
}