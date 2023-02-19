package com.example.StudentLibraryManagment.Services;

import com.example.StudentLibraryManagment.DTOs.AuthorEntryDto;
import com.example.StudentLibraryManagment.Models.Author;
import com.example.StudentLibraryManagment.Models.Book;
import com.example.StudentLibraryManagment.Repositories.AuthorRepository;
import com.example.StudentLibraryManagment.ResponseDTO.AuthorResponseDTO;
import com.example.StudentLibraryManagment.ResponseDTO.BookResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorEntryDto authorEntryDto){

        Author author = new Author();

        author.setAge(authorEntryDto.getAge());
        author.setName(authorEntryDto.getName());
        author.setCountry(authorEntryDto.getCountry());
        author.setRating(authorEntryDto.getRating());

        authorRepository.save(author);

        return "Author added successfully";
    }

    public AuthorResponseDTO getAuthor(int authorId){

        Author author = authorRepository.findById(authorId).get();


        AuthorResponseDTO authorDto = new AuthorResponseDTO();


        //set the attributes

        //List<Book> --> List<BookDTo>
        List<Book> bookList = author.getBooksWritten();

        List<BookResponseDTO> bookWritten = new ArrayList<>();

        for(Book book : bookList){

            BookResponseDTO bookResponseDTO = new BookResponseDTO();
            bookResponseDTO.setGenre(book.getGenre());
            bookResponseDTO.setPages(book.getPages());
            bookResponseDTO.setName(book.getName());

            bookWritten.add(bookResponseDTO);
        }

        // set attributes for author response Dto
        authorDto.setBookWritten(bookWritten);
        authorDto.setAge(author.getAge());
        authorDto.setName(author.getName());
        authorDto.setRating(author.getRating());

        return authorDto;


    }
}
