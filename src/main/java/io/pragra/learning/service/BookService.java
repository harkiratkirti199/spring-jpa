package io.pragra.learning.service;

import io.pragra.learning.domain.Book;
import io.pragra.learning.exceptions.AuthorNotFoundException;
import io.pragra.learning.exceptions.BookNotFoundException;
import io.pragra.learning.repo.AuthorRepo;
import io.pragra.learning.repo.BookRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepo repo;
    private AuthorRepo authorRepo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }

    public List<Book> getAll(){
        return repo.findAll();
    }

    public Book getBookById(Long id){
        Optional<Book> bok = repo.findById(id);
        if(bok.isPresent()) {
            return bok.get();
        }
        else{
            throw new BookNotFoundException("Not Found any Book");
        }
    }

    public Book createBook(@RequestBody Book book){
        Long id=book.getAuthor().getId();
        if(!authorRepo.findById(id).isPresent()){
            throw new AuthorNotFoundException("Author Doesn't exist");
        }
        return repo.save(book);

    }






}
