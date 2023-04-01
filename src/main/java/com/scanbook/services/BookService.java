package com.scanbook.services;

import com.scanbook.model.Book;
import com.scanbook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(int isbn){
        bookRepository.deleteById(isbn);
    }
    public Book getBook(int isbn){
        return bookRepository.findByIsbn(isbn);
    }
    public List<Book> getBooks(){
        return (List<Book>) bookRepository.findAll();
    }

    public Book updateBook(int isbn, Book bookDetails){
        Book book =bookRepository.findByIsbn(isbn);
        book.setAuthor(bookDetails.getAuthor());
        book.setTitle(bookDetails.getTitle());
        book.setPages(bookDetails.getPages());
        book.setCompleted(bookDetails.isCompleted());
        book.setNotes(bookDetails.getNotes());
//        String currentNotes = book.getNotes();
//        String newNotes = currentNotes != null ? currentNotes+"&#13;&#10;"+bookDetails.getNotes(): bookDetails.getNotes();
//        book.setNotes(newNotes);

        return bookRepository.save(book);
    }
}
