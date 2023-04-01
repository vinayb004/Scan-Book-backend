package com.scanbook.repository;

import com.scanbook.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    Book findByIsbn(int isbn);
}
