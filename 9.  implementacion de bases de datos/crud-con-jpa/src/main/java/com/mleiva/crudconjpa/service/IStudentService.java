package com.mleiva.crudconjpa.service;


import com.mleiva.crudconjpa.model.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> getStudents();
    public void saveStudent(Student stu);
    public void deleStudent(long id);
    public Student findStudent(long id);

}
