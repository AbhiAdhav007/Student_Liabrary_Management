package com.example.StudentLibraryManagment.ResponseDTO;

import com.example.StudentLibraryManagment.Enums.Genre;

public class BookResponseDTO {

    private String name;

    private Genre genre;

    private int pages;


    public BookResponseDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
