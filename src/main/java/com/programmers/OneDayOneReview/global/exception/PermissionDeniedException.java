package com.programmers.OneDayOneReview.global.exception;

import com.programmers.OneDayOneReview.global.response.ErrorCode;
import lombok.Getter;

@Getter
public class PermissionDeniedException extends RuntimeException {
    private ErrorCode errorCode;

    public PermissionDeniedException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
