package io.pragra.learning.springjpa;

import io.pragra.learning.domain.Author;
import io.pragra.learning.domain.Book;
import io.pragra.learning.domain.RefData;
import io.pragra.learning.domain.StatusEnum;
import io.pragra.learning.repo.BookRepo;
import io.pragra.learning.repo.RefDataRepo;
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
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages="io.pragra.learning.repo")
@EntityScan(basePackages="io.pragra.learning.domain")
@ComponentScan(basePackages="io.pragra.learning")
public class SpringJpaApplication {
	@Autowired
	private BookRepo repo;

	@Autowired
	private RefDataRepo refDataRepo;



	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Author auth1=new Author("John Doe","Pragra","Learning",new Date(),new Date(), StatusEnum.ACTIVE);
			Author auth2=new Author("Jean Doe","XYZ","Learning",new Date(),new Date(), StatusEnum.ACTIVE);
			Author auth3=new Author("John Doe2","ABC","Learning",new Date(),new Date(), StatusEnum.ACTIVE);
			Author auth4=new Author("John Doe3","CDE","Learning",new Date(),new Date(), StatusEnum.ACTIVE);

//			Book book=new Book(122201202L,"HarryPotter",Arrays.asList(auth4),"fiction",200);
			Book book=new Book(122201202L,"HarryPotter",auth4,"fiction",200);
			Book book2=new Book(1222012034L,"HarryPotter 2",auth2,"fiction",250);
			Book book3=new Book(1222012038L,"HarryPotter 3",auth1,"fiction",300);
			Book book4=new Book(1222012039L,"HarryPotter 4",auth3,"fiction",350);
//			List<Book> all= Arrays.asList(book,book2);
			Book save = repo.save(book2);
			Book save2 = repo.save(book);
			Book save3 = repo.save(book3);
			Book save4 = repo.save(book4);
			System.out.println(save);

			System.out.println(repo.findAllByPrice(200));
//			System.out.println(repo.findByAuthor("John Doe"));
			System.out.println(repo.countAll());
			System.out.println(repo.countByAuthor());

			refDataRepo.save(new RefData("Apple","Fruits"));
			refDataRepo.save(new RefData("Grapes","Fruits"));



		};
	}

}
