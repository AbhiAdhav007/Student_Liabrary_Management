package com.example.StudentLibraryManagment.Controllers;

import com.example.StudentLibraryManagment.DTOs.BookReqDto;
import com.example.StudentLibraryManagment.Models.Book;
import com.example.StudentLibraryManagment.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {


    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public String addBook(@RequestBody BookReqDto bookReqDto){

        return bookService.addBook(bookReqDto);

    }
}
