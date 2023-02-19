package com.example.StudentLibraryManagment.Controllers;

import com.example.StudentLibraryManagment.DTOs.AuthorEntryDto;
import com.example.StudentLibraryManagment.Models.Author;
import com.example.StudentLibraryManagment.ResponseDTO.AuthorResponseDTO;
import com.example.StudentLibraryManagment.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    //   / is optional you want to write you can
    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorEntryDto authorEntryDto){

        return authorService.createAuthor(authorEntryDto);
    }

    @GetMapping("/get_author")
    public AuthorResponseDTO getAuthor (@RequestParam int authorId){

        return authorService.getAuthor(authorId);
    }
}
