package io.pragra.learning.domain;

import io.pragra.learning.repo.BookRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="table_author")
@Data
@NoArgsConstructor
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="auth_id")
    private long id;
    private String name;
    private String company;
    private String institution;
    private Date createDate;
    private Date updateDate;
    private StatusEnum status;


    public Author(String name, String company, String institution, Date createDate, Date updateDate, StatusEnum status) {
        this.name = name;
        this.company = company;
        this.institution = institution;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
    }

    @RestController
    @RequestMapping("/api")
    public static class BookController {
        private BookRepo repo;

        public BookController(BookRepo repo) {
            this.repo = repo;
        }

        @RequestMapping(value="/books",method = RequestMethod.GET)
        public List<Book> getAll(){
            return repo.findAll();
        }

    //    @RequestMapping(value="/book",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    //    public Book createBook(@RequestBody Book book){
    //        return repo.save(book);
    //    }
    }
}
