package com.example.StudentLibraryManagment.DTOs;

import com.example.StudentLibraryManagment.Models.Book;

public class IssueBookDto {

    private int bookId;

    private int cardId;

    public IssueBookDto(int bookId, int cardId) {

        this.bookId = bookId;
        this.cardId = cardId;
    }

    public IssueBookDto() {


    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
