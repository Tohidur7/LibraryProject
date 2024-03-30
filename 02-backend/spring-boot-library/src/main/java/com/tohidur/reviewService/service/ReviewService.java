package com.tohidur.reviewService.service;


import com.tohidur.reviewService.responseData.ReviewListResponseData;

public interface ReviewService {
    ReviewListResponseData getReviewByBookId(Long bookId, int pageNo, int pageSize);
}
