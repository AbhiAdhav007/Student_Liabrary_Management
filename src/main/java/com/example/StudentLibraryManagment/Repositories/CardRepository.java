package com.example.StudentLibraryManagment.Repositories;

import com.example.StudentLibraryManagment.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card , Integer> {
}
