package com.tohidur.service;

import com.tohidur.responseData.BookListResponseData;
import com.tohidur.responseData.BookResponseData;

public interface BookService {

    public BookListResponseData getBooks(int pageNo, int pageSize) ;

    public BookListResponseData getBooksByTitleContaining(String title, int pageNo, int pageSize);

    public BookListResponseData getBooksByCategory(String category, int pageNo, int pageSize);

    public BookResponseData getBookByBookId(Long bookId);
}
