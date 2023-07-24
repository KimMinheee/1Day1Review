package com.programmers.OneDayOneReview.global.exception;

import com.programmers.OneDayOneReview.global.response.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private ErrorCode errorCode;

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
