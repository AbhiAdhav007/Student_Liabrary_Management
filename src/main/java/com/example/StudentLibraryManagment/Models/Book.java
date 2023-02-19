package com.example.StudentLibraryManagment.Models;

import com.example.StudentLibraryManagment.Enums.Genre;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int pages;

    private boolean isIssued;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    public Book(){


    }

    //Book is child wrt to author
    //setting here the foreign key
    @ManyToOne
    @JoinColumn
    private Author author;

    //Book is child wrt to card

    @ManyToOne
    @JoinColumn
    private Card card;


    //Book is parent class for the transation

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Transaction> listOfTransactions = new ArrayList<>();

    public List<Transaction> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(List<Transaction> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
