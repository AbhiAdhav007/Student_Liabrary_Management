package com.example.StudentLibraryManagment.Repositories;

import com.example.StudentLibraryManagment.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book , Integer> {
}
