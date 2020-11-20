package io.pragra.learning.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="table_book")
@Data
@NoArgsConstructor
@ToString
public class Book {
    /**
     * If you want multiple columns with primary key, create a new class and add those columns and use that class in this class.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="book_id")
    private Long id;
    private Long isbn;
    @Column(length = 255)
    private String title;
    private String author;
    private String category;
    private double price;

    public Book(Long isbn, String title, String author, String category, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }


}
