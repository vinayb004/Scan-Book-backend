package com.scanbook.contoller;

import com.scanbook.model.Book;
import com.scanbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return ResponseEntity.ok(newBook);
    }
    @RequestMapping(value = "/book/{barcode}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBook(@PathVariable int barcode){
        bookService.deleteBook(barcode);
        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value="/book/{barcode}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBook(@PathVariable int barcode){
        Book infoBook = bookService.getBook(barcode);
        if(infoBook == null){
            System.out.println("Not found a book");
            return ResponseEntity.notFound().build();
        }
        System.out.println("found a book");
        return ResponseEntity.ok(infoBook);
    }
}
