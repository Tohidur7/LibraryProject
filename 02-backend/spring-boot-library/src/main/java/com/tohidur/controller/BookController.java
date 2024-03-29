package com.tohidur.controller;


import com.tohidur.constant.BookConstants;
import com.tohidur.responseData.BookListResponseData;
import com.tohidur.responseData.BookResponseData;
import com.tohidur.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class BookController {

    private BookService bookService ;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Fetch all books from the database
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(path = "/books")
    public ResponseEntity<BookListResponseData> getBooks(
            @RequestParam(value ="pageNo", defaultValue = BookConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value ="pageSize", defaultValue = BookConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize
    ){

        return new ResponseEntity<>(bookService.getBooks(pageNo, pageSize), HttpStatus.OK) ;
    }

    /**
     * Fetch all books containing input titles
     * @param title
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(path = "/books/search/findByTitleContaining")
    public ResponseEntity<BookListResponseData> getBooksByTitleContaining(
            @RequestParam(value = "title", defaultValue = BookConstants.DEFAULT_TITLE, required = false) String title,
            @RequestParam(value ="pageNo", defaultValue = BookConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value ="pageSize", defaultValue = BookConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize
    ){

        return new ResponseEntity<>(bookService.getBooksByTitleContaining(title, pageNo, pageSize), HttpStatus.OK) ;
    }

    /**
     * Fetch all books with category
     * @param category
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(path = "/books/search/findByCategory")
    public ResponseEntity<BookListResponseData> getBooksByCategory(
            @RequestParam(value = "category", defaultValue = BookConstants.DEFAULT_TITLE, required = false) String category,
            @RequestParam(value ="pageNo", defaultValue = BookConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value ="pageSize", defaultValue = BookConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize
    ){

        return new ResponseEntity<>(bookService.getBooksByCategory(category, pageNo, pageSize), HttpStatus.OK) ;
    }

    @GetMapping(path = "/books/{bookId}")
    public ResponseEntity<BookResponseData> getBookByBookId(@PathVariable(value = "bookId") Long bookId){

        return new ResponseEntity<>(bookService.getBookByBookId(bookId), HttpStatus.OK) ;
    }
}
