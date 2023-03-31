package com.scanbook.services;

import com.scanbook.model.Book;
import com.scanbook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
