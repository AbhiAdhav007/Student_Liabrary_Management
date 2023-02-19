package com.example.StudentLibraryManagment.Services;

import com.example.StudentLibraryManagment.DTOs.BookReqDto;
import com.example.StudentLibraryManagment.Models.Author;
import com.example.StudentLibraryManagment.Models.Book;
import com.example.StudentLibraryManagment.Repositories.AuthorRepository;
import com.example.StudentLibraryManagment.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;
    public String addBook(BookReqDto bookReqDto){

        Author author = authorRepository.findById(bookReqDto.getAuthorId()).get();

        Book book = new Book();

        book.setGenre(bookReqDto.getGenre());
        book.setName(bookReqDto.getName());
        book.setPages(bookReqDto.getPages());
        book.setIssued(false);
        book.setAuthor(author);



        //i want to get author Entity
//        int authorId = book.getAuthor().getId();
//
//        // Now i will be fetch the author
//
//            Author author = authorRepository.findById(authorId).get();
//
//            book.setAuthor(author);
//
//            // we need to update list of book wrriten
//
        List<Book> currBookWritten = author.getBooksWritten();
        currBookWritten.add(book);

        author.setBooksWritten(currBookWritten);

        // now book is to be saved but author is also to be saved

        // we are not saving the author we are updating author


        // save works both for save and update
        authorRepository.save(author);

        // using cascading effect book save automatically

        return "Book added Successfully";

    }
}
