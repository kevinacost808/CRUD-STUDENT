package com.kevin.student.controller;


import com.kevin.student.models.Student;
import com.kevin.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String studentList(Model model){
        List<Student> studentsList = studentService.getAll();
        model.addAttribute("studentsList",studentsList);
        return "index";
    }

    @GetMapping("/openForm")
    public String openForm(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("action", "/student/newStudent");
        return "addForm";
    }

    @PostMapping("/newStudent")
    public String addStudent(@ModelAttribute Student student){
        studentService.addStudent(student);
        return "redirect:/student";
    }

    @GetMapping("/openFormEdit/{id}")
    public String openFormEdit(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentId(id));
        model.addAttribute("action", "/student/editStudent/"+id);
        return "editForm";
    }

    @PostMapping("/editStudent/{id}")
    public String editStudent(@PathVariable Long id, @ModelAttribute("student") Student student){
        studentService.editStudent(id, student);
        return "redirect:/student";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/student";
    }

}
