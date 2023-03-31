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

    public void deleteBook(int barcode){
        bookRepository.deleteById(barcode);
    }
    public Book getBook(int barcode){
        return bookRepository.findByBarcode(barcode);
    }
    public List<Book> getBooks(){
        return (List<Book>) bookRepository.findAll();
    }

    public Book updateBook(int barcode, Book bookDetails){
        Book book =bookRepository.findByBarcode(barcode);
        book.setAuthor(bookDetails.getAuthor());
        book.setTitle(bookDetails.getTitle());
        book.setPages(bookDetails.getPages());
        book.setCompleted(bookDetails.isCompleted());
        return bookRepository.save(book);
    }
}
