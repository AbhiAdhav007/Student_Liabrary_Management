package com.example.StudentLibraryManagment.DTOs;

import com.example.StudentLibraryManagment.Enums.Genre;

public class BookReqDto {


    private String name;

    private int pages;

    private Genre genre;

    private int authorId;

    public BookReqDto(){


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
