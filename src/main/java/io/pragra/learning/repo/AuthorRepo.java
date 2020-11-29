package io.pragra.learning.repo;

import io.pragra.learning.domain.Author;
import io.pragra.learning.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {
}
