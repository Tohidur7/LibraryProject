package com.tohidur.service;

import com.tohidur.entity.Book;
import com.tohidur.repository.BookRepository;
import com.tohidur.responseData.BookListResponseData;
import com.tohidur.responseData.BookResponseData;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository ;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookListResponseData getBooks(int pageNo, int pageSize) {

        //create a pageable instance
        Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize);

        //fetching books from the database
        Page<Book> page = bookRepository.findAll(pageable);

        //get content from the page object
        List<Book> content = page.getContent();

        //setting data into response object
        BookListResponseData response = new BookListResponseData();

        response.setContent(content);
        response.setPageNo(page.getNumber());
        response.setPageSize(page.getSize());
        response.setTotalElement(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setLast(page.isLast());

        return  response ;
    }

    @Override
    public BookListResponseData getBooksByTitleContaining(String title, int pageNo, int pageSize) {

        //create a pageable instance
        Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize);

        //fetching books from the database
        Page<Book> page = bookRepository.findByTitleContaining(title, pageable);

        //get content from the page object
        List<Book> content = page.getContent();

        //setting data into response object
        BookListResponseData response = new BookListResponseData();

        response.setContent(content);
        response.setPageNo(page.getNumber());
        response.setPageSize(page.getSize());
        response.setTotalElement(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setLast(page.isLast());

        return  response ;
    }

    @Override
    public BookListResponseData getBooksByCategory(String category, int pageNo, int pageSize) {

        //create a pageable instance
        Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize);

        //fetching books from the database
        Page<Book> page = bookRepository.findByCategory(category, pageable);

        //get content from the page object
        List<Book> content = page.getContent();

        //setting data into response object
        BookListResponseData response = new BookListResponseData();

        response.setContent(content);
        response.setPageNo(page.getNumber());
        response.setPageSize(page.getSize());
        response.setTotalElement(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setLast(page.isLast());

        return  response ;
    }

    @Override
    public BookResponseData getBookByBookId(Long bookId) {

        Optional<Book> byId = bookRepository.findById(bookId);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("Entity not found with provided Id") ;
        }

        Book book = byId.get();

        //get the response object from entity
        BookResponseData bookResponseData = new BookResponseData();

        bookResponseData.setId(book.getId());
        bookResponseData.setTitle(book.getTitle());
        bookResponseData.setAuthor(book.getAuthor());
        bookResponseData.setDescription(book.getDescription());
        bookResponseData.setCopies(book.getCopies());
        bookResponseData.setCopiesAvailable(book.getCopiesAvailable());
        bookResponseData.setCategory(book.getCategory());
        bookResponseData.setImg(book.getImg());


        return bookResponseData;
    }
}
