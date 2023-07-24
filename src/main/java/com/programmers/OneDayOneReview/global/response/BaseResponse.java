package com.programmers.OneDayOneReview.global.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.programmers.OneDayOneReview.global.response.SuccessCode.SUCCESS;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"status", "code", "message", "result"})
public class BaseResponse<T> {
    private final int status;
    private final String message;
    private final String code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    /**
     * 요청에 성공하고 반환값이 있는 경우
     *
     * @param result
     */
    public BaseResponse(T result) {
        this.status = SUCCESS.getStatus();
        this.message = SUCCESS.getMessage();
        this.code = SUCCESS.getCode();
        this.result = result;
    }

    /**
     * 요청에 성공하고 반환값이 없는 경우
     *
     * @param status
     */
    public BaseResponse(SuccessCode status) {
        this.status = status.getStatus();
        this.message = status.getMessage();
        this.code = status.getCode();
    }

}
