package com.tohidur.reviewService.controller;


import com.tohidur.bookService.constant.BookConstants;
import com.tohidur.reviewService.constant.ReviewConstants;
import com.tohidur.reviewService.entity.Review;
import com.tohidur.reviewService.responseData.ReviewListResponseData;
import com.tohidur.reviewService.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/reviews")
public class ReviewController {

    private ReviewService reviewService ;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping(path = "/search/findByBookId")
    public ResponseEntity<ReviewListResponseData> getReviewByBookId(
            @RequestParam(value = "bookId", defaultValue = ReviewConstants.BOOK_ID, required = false) Long bookId,
            @RequestParam(value ="pageNo", defaultValue = ReviewConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value ="pageSize", defaultValue = ReviewConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize
    ){

        return new ResponseEntity(reviewService.getReviewByBookId(bookId, pageNo, pageSize), HttpStatus.OK);
    }
}
