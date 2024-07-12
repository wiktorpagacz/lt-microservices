package com.pagacz.resvault.controller;

import com.pagacz.resvault.model.BookRequest;
import com.pagacz.resvault.model.BookResponse;
import com.pagacz.resvault.model.CourseRequest;
import com.pagacz.resvault.model.CourseResponse;
import com.pagacz.resvault.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Long> addBook(@RequestBody BookRequest bookRequest) {
        Long bookId = bookService.saveBook(bookRequest);
        return new ResponseEntity<>(bookId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable("id") long id) {
        BookResponse bookResponse = bookService.getBookById(id);
        return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable("id") long id, @RequestBody BookRequest bookRequest) {
        BookResponse bookResponse = bookService.updateBook(id, bookRequest);
        return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }
}
