package com.example.StudentLibraryManagment.Services;


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
}
