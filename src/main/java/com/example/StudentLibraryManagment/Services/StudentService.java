package com.example.StudentLibraryManagment.Services;


import com.example.StudentLibraryManagment.DTOs.StudentMobNoUpdateDto;
import com.example.StudentLibraryManagment.Enums.CardStatus;
import com.example.StudentLibraryManagment.Models.Card;
import com.example.StudentLibraryManagment.Models.Student;
import com.example.StudentLibraryManagment.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;
    public String create_Student(Student student){

        //Student from the postman is already the basic attribute set

        //Card should be autogenrated when student function is called

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudentVariableName(student);

        //lets set for the student
        student.setCard(card);

        //If there is unidirectional mapping then we have to save both of them
        //BUt we are using the bidirectional mapping child will be automatically saved.

        studentRepository.save(student);
        //By cascading effect child is automatically saved
        return "";
    }

    public String getNameByEmail(String email){

        Student student = studentRepository.findByEmail(email);

        return student.getName();


    }

    public String updateMobNo(StudentMobNoUpdateDto studentMobNoUpdateDto){


        Student originalStudent = studentRepository.findById(studentMobNoUpdateDto.getId()).get();

        originalStudent.setMobNo(studentMobNoUpdateDto.getMobNo());

//        //try TO fetch old student/original student
//
//        Student originalStudent = studentRepository.findById(student.getId()).get();
//
//        //we will only change the required attribute to be changed
//
//        originalStudent.setMobNo(student.getMobNo());

        //Always entity object is been saved

//
          studentRepository.save(originalStudent);

        return "Student mobile number updated successfully";

    }
}
