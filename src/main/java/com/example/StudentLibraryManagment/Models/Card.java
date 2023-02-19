package com.example.StudentLibraryManagment.Models;

import com.example.StudentLibraryManagment.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="card")
public class Card {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp //add timestamp the time when created the entry
    private Date createdOn;

    @UpdateTimestamp  //set time when entity is updated
    private Date updateOn;

    @Enumerated(value = EnumType.STRING)  //we set it to the string format to tell the SQL
    private CardStatus cardStatus;



    @OneToOne
    @JoinColumn
    private Student studentVariableName;


    //Card is book wrt to book

    @OneToMany(mappedBy = "card" , cascade = CascadeType.ALL)
    private List<Book> booksIssued = new ArrayList<>();

    //Card is the parent class for the transaction
    @OneToMany(mappedBy = "card" , cascade = CascadeType.ALL)
    private List<Transaction> listOfTransactions = new ArrayList<>();

    public List<Transaction> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(List<Transaction> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }

    public Card(){


    }

    public Card(int id, Date createdOn, Date updateOn, CardStatus cardStatus) {
        this.id = id;
        this.createdOn = createdOn;
        this.updateOn = updateOn;
        this.cardStatus = cardStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Student getStudentVariableName() {
        return studentVariableName;
    }

    public void setStudentVariableName(Student studentVariableName) {
        this.studentVariableName = studentVariableName;
    }

    public List<Book> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(List<Book> booksIssued) {
        this.booksIssued = booksIssued;
    }
}
