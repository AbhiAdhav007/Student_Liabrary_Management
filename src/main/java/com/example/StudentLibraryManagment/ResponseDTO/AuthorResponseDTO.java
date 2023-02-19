package com.example.StudentLibraryManagment.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class AuthorResponseDTO {

    private String name;

    private Double rating;

    private String country;

    private int age;

    private List<BookResponseDTO> bookWritten = new ArrayList<>();

    public AuthorResponseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<BookResponseDTO> getBookWritten() {
        return bookWritten;
    }

    public void setBookWritten(List<BookResponseDTO> bookWritten) {
        this.bookWritten = bookWritten;
    }
}
