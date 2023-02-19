package com.example.StudentLibraryManagment.Controllers;

import com.example.StudentLibraryManagment.DTOs.IssueBookDto;
import com.example.StudentLibraryManagment.Models.Transaction;
import com.example.StudentLibraryManagment.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue_book")
    public String issueBook(@RequestBody IssueBookDto issueBookDto){

        try{
            return transactionService.issueBook(issueBookDto);
        }catch (Exception e){
            return e.getMessage();
        }

    }

}
