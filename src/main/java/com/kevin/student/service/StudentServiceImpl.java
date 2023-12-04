package com.kevin.student.service;

import com.kevin.student.models.Student;
import com.kevin.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student editStudent(Long id, Student student) {
        Student editStudent = studentRepository.findById(id).orElse(null);
        if(editStudent != null){
            editStudent.setName(student.getName());
            editStudent.setLastName(student.getLastName());
            editStudent.setAge(student.getAge());
            editStudent.setEmail(student.getEmail());
            return studentRepository.save(editStudent);
        }
        return null;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
