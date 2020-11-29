package io.pragra.learning.repo;

import io.pragra.learning.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

    List<Book> findAllByPrice(double price);

    List<Book> findByAuthor(String author);

    @Query(value = "select count(*) from table_book", nativeQuery = true)
    long countAll();

    @Query("select count(b) from Book b where price=200")
    long countByAuthor();


}
