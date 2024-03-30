package com.tohidur.reviewService.service;

import com.tohidur.reviewService.entity.Review;
import com.tohidur.reviewService.repository.ReviewRepository;
import com.tohidur.reviewService.responseData.ReviewListResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public ReviewListResponseData getReviewByBookId(Long bookId, int pageNo, int pageSize) {

        // create a pageable instance
        Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize);
        
        // fetching books from the database
        Page<Review> page = reviewRepository.findByBookId(bookId, pageable);

        // get content from the page object
        List<Review> content = page.getContent();

        // setting data into response object
        ReviewListResponseData response = new ReviewListResponseData();

        response.setContent(content);
        response.setPageNo(page.getNumber());
        response.setPageSize(page.getSize());
        response.setTotalElement(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setLast(page.isLast());

        return response;
    }
}
