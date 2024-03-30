package com.tohidur.bookService.service;

import com.tohidur.bookService.responseData.BookListResponseData;
import com.tohidur.bookService.responseData.BookResponseData;

public interface BookService {

    public BookListResponseData getBooks(int pageNo, int pageSize) ;

    public BookListResponseData getBooksByTitleContaining(String title, int pageNo, int pageSize);

    public BookListResponseData getBooksByCategory(String category, int pageNo, int pageSize);

    public BookResponseData getBookByBookId(Long bookId);
}
