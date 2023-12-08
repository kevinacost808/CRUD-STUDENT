package com.kevin.student.service;

import com.kevin.student.models.Student;

import java.util.List;

public interface StudentService{
    Student addStudent(Student student);
    Student editStudent(Long id, Student student);
    List<Student> getAll();
    void deleteStudent(Long id);
    Student getStudentId(Long id);
}
