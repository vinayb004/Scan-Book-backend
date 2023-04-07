package com.scanbook.repository;

import com.scanbook.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByIsbn(long isbn);
    Optional<Book> findByIsbn(Long isbn);
}
