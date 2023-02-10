package com.example.StudentLibraryManagment.Controllers;


import com.example.StudentLibraryManagment.Models.Student;
import com.example.StudentLibraryManagment.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String create_Student(@RequestBody Student student){

        studentService.create_Student(student);
        return "Student added Successfully";
    }
}
