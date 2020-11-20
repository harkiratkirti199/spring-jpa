package io.pragra.learning.springjpa;

import io.pragra.learning.domain.Book;
import io.pragra.learning.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages="io.pragra.learning.repo")
@EntityScan(basePackages="io.pragra.learning.domain")
public class SpringJpaApplication {
	@Autowired
	private BookRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Book book=new Book(122201202L,"HarryPotter","John Doe","fiction",200);
			Book book2=new Book(1222012034L,"HarryPotter 2","John Doe2","fiction",250);
//			List<Book> all= Arrays.asList(book,book2);
			Book save = repo.save(book2);
			System.out.println(save);

		};
	}

}
