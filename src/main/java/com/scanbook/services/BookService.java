package com.scanbook.services;

import com.scanbook.model.Book;
import com.scanbook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(long isbn){
        bookRepository.deleteById(isbn);
    }
    public Book getBook(long isbn){
        return bookRepository.findByIsbn(isbn);
    }
    public List<Book> getBooks(){
        return (List<Book>) bookRepository.findAll();
    }

    public Book updateBook(long isbn, Book bookDetails){

        Book book =bookRepository.findByIsbn(isbn);
        if ( !bookDetails.getAuthor().isEmpty()) {
            book.setAuthor(bookDetails.getAuthor());
        }
        if (!bookDetails.getTitle().isEmpty()) {
            book.setTitle(bookDetails.getTitle());
        }
        if (bookDetails.getPages() != 0 ) {
            book.setPages(bookDetails.getPages());
        }

        book.setCompleted(bookDetails.isCompleted());

        if (!bookDetails.getNotes().isEmpty()) {
            book.setNotes(bookDetails.getNotes());
        }

        return bookRepository.save(book);
    }

    public boolean existsByIsbn(long isbn) {
        Optional<Book> book = Optional.ofNullable(bookRepository.findByIsbn(isbn));
        return book.isPresent();
    }
}
