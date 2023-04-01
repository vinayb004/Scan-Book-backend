package com.scanbook.contoller;

import com.scanbook.model.Book;
import com.scanbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping("/addbook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return ResponseEntity.ok(newBook);
    }
    @RequestMapping(value = "/book/{isbn}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBook(@PathVariable int isbn){
        bookService.deleteBook(isbn);
        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value="/book/{isbn}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBook(@PathVariable int isbn){
        Book infoBook = bookService.getBook(isbn);
        if(infoBook == null){
            System.out.println("Not found a book");
            return ResponseEntity.notFound().build();
        }
        System.out.println("found a book");
        return ResponseEntity.ok(infoBook);
    }

    @RequestMapping(value="/allbooks", method=RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks() {
        List<Book>  books= bookService.getBooks();
        if(books == null){
            System.out.println("No books found");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(books);
    }

    @RequestMapping(value="/updateBook/{isbn}", method=RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@PathVariable int isbn, @RequestBody Book book) {
        Book updateBook = bookService.updateBook(isbn, book);
        return ResponseEntity.ok(updateBook);
    }
}
