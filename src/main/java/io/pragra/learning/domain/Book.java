package io.pragra.learning.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="table_book")
@Data
@NoArgsConstructor
@ToString
public class Book {
    /**
     * If you want multiple columns with primary key, create a new class and add those columns and use that class in this class.
     * If you are using @OneToOne(cascade = CascadeType.ALL), we use cascade type all to make sure author are created before books are created as it is looking for auth_id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="book_id")
    private Long id;
    private Long isbn;
    @Column(length = 255)
    private String title;
//    @ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL,targetEntity = Author.class)
//    @JoinColumn(name = "auth_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
    private String category;
    private double price;

    public Book(Long isbn, String title, Author author, String category, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }
}
