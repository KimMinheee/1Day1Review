package com.programmers.OneDayOneReview.global.response;


public enum SuccessCode {
    /**
     * 1000번 -> 성공
     */
    SUCCESS(200, "1000", "요청에 성공하였습니다."),

    /**
     * 2000번 -> Member
     */

    /**
     * 3000번 -> Post
     */
    UPDATE_POST_SUCCESS(200, "P3000", "게시글 수정에 성공하였습니다."),
    DELETE_POST_SUCCESS(200, "P3001", "게시글 삭제에 성공하였습니다."),
    POST_LIKE_SUCCESS(200, "P3002", "게시물 좋아요 추가에 성공하였습니다.");


    private final int status;
    private final String code;
    private final String message;

    private SuccessCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }
}
