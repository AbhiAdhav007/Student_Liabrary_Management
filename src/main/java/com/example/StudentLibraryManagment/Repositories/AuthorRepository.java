package com.example.StudentLibraryManagment.Repositories;

import com.example.StudentLibraryManagment.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author , Integer> {
}
