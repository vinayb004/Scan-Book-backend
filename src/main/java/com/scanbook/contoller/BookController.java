package com.scanbook.contoller;

import com.scanbook.model.Book;
import com.scanbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping("/addbook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }
    @DeleteMapping("/book/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable long isbn){
        bookService.deleteBook(isbn);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/book/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable long isbn){
        Book infoBook = bookService.getBook(isbn);
        if(infoBook == null){
            System.out.println("Not found a book");
            return ResponseEntity.notFound().build();
        }
        System.out.println("found a book");
        return ResponseEntity.ok(infoBook);
    }

    @GetMapping("/allbooks")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book>  books= bookService.getBooks();
        if(books == null){
            System.out.println("No books found");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(books);
    }

    @PutMapping("/updateBook/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable long isbn, @RequestBody Book book) {
        Book updateBook = bookService.updateBook(isbn, book);
        return ResponseEntity.ok(updateBook);
    }

    @GetMapping("/checkISBN/{isbn}")
    public ResponseEntity<?> checkISBN(@PathVariable long isbn) {
        boolean exists = bookService.existsByIsbn(isbn);
        Map<String, Object> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }
}
