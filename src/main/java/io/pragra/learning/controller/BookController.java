package io.pragra.learning.controller;

import io.pragra.learning.domain.Book;
import io.pragra.learning.repo.BookRepo;
import io.pragra.learning.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }


    @GetMapping()
    public List<Book> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id){
        return service.getBookById(id);

    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return service.createBook(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return service.createBook(book);
    }
}
