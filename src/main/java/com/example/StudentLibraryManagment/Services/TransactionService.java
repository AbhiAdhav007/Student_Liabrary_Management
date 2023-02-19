package com.example.StudentLibraryManagment.Services;

import com.example.StudentLibraryManagment.DTOs.IssueBookDto;
import com.example.StudentLibraryManagment.Enums.CardStatus;
import com.example.StudentLibraryManagment.Enums.TransactionStatus;
import com.example.StudentLibraryManagment.Models.Book;
import com.example.StudentLibraryManagment.Models.Card;
import com.example.StudentLibraryManagment.Models.Transaction;
import com.example.StudentLibraryManagment.Repositories.BookRepository;
import com.example.StudentLibraryManagment.Repositories.CardRepository;
import com.example.StudentLibraryManagment.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;
    public String issueBook(IssueBookDto issueBookDto) throws Exception{


        //Get the book entity and card entity because we want to set transaction attributes
        Book book = bookRepository.findById(issueBookDto.getBookId()).get();

        Card card = cardRepository.findById(issueBookDto.getCardId()).get();

        Transaction transaction = new Transaction();

        //setting the Attributes

        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setIssueOperation(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);


        // Do some Validation

        if(book == null || book.isIssued() == true){

            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not Available");
        }

        if(card == null || card.getCardStatus() != CardStatus.ACTIVATED){

            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not Valid");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        //set the attributes of the book
        book.setIssued(true);

        List<Transaction> listOfTransactionForBook = book.getListOfTransactions();
        listOfTransactionForBook.add(transaction);
        book.setListOfTransactions(listOfTransactionForBook);


        //Setting the foreign key and bidirectional
        List<Book> bookList = card.getBooksIssued();
        bookList.add(book);
        card.setBooksIssued(bookList);

        List<Transaction> listOfTransactionForCard = card.getListOfTransactions();
        listOfTransactionForCard.add(transaction);
        card.setListOfTransactions(listOfTransactionForCard);

        //save the parent object

        cardRepository.save(card);
        // automatically book and transaction will be save because
        // by cascading effect if we save the parent entity child entity also to be saved

        return "Transaction is Successful and book is register for your Card";
    }
}
