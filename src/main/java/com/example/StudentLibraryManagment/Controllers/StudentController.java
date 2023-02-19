package com.example.StudentLibraryManagment.Controllers;


import com.example.StudentLibraryManagment.DTOs.StudentMobNoUpdateDto;
import com.example.StudentLibraryManagment.Models.Student;
import com.example.StudentLibraryManagment.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String create_Student(@RequestBody Student student){

        studentService.create_Student(student);
        return "Student added Successfully";
    }

    @GetMapping("/get_user")
    public String getNameByEmail(String email){

        return studentService.getNameByEmail(email);
    }

    @PutMapping("/update_mob")
    public String updateMobNo(@RequestBody StudentMobNoUpdateDto studentMobNoUpdateDto){

        return studentService.updateMobNo(studentMobNoUpdateDto);

    }
}
