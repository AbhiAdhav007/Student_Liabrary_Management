package com.example.StudentLibraryManagment.Repositories;

import com.example.StudentLibraryManagment.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student , Integer> {


    Student findByEmail(String email);
}
