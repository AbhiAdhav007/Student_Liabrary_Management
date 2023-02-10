package com.example.StudentLibraryManagment.Repositories;

import com.example.StudentLibraryManagment.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student , Integer> {
}
