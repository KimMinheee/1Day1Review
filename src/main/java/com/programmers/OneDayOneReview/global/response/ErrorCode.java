package com.programmers.OneDayOneReview.global.response;

public enum ErrorCode {
    /**
     * 10000번 -> Global에서 발생하는 에러코드 관리
     * [Http Status code]
     * 400 : Bad Request
     * 401 : Unauthorized
     * 403 : Forbidden
     * 404 : Not Found
     * 405 : Method Not Allowed
     * 500 : Internal Server Error
     */
    FAIL(500, "10000", "요청에 실패하였습니다."),
    INVALID_INPUT_VALUE_ERROR(400, "10001", "유효하지 않은 입력값입니다."),
    INVALID_METHOD_ERROR(405, "10002", "지원하지 않는 HTTP 메소드입니다."),
    REQUEST_BODY_MISSING_ERROR(400, "10003", "RequestBody에 데이터가 존재하지 않습니다."),
    REQUEST_PARAM_MISSING_ERROR(400, "10004", "RequestParam에 데이터가 전달되지 않았습니다."),
    INVALID_TYPE_VALUE_ERROR(400, "10005", "타입이 유효하지 않습니다."),
    INTERNAL_SERVER_ERROR(500, "10006", "서버 오류 입니다."),

    /**
     * ==========================================================================
     * 20000번 -> Member에서 발생하는 에러코드 관리
     * ==========================================================================
     */
    NOT_EXIST_MEMBER(404, "M20000", "회원을 찾을 수 없습니다."),

    /**
     * ==========================================================================
     * 30000번 -> Post에서 발생하는 에러코드 관리
     * ==========================================================================
     */
    NOT_EXIST_POST(404, "P30000", "게시글을 찾을 수 없습니다."),
    PERMISSION_DENIED_UPDATE_POST(403, "P30001", "게시글을 수정할 권한이 없습니다."),
    PERMISSION_DENIED_DELETE_POST(403, "P30002", "게시글을 삭제할 권한이 없습니다.");


    private final int status; //코드 상태(Http)
    private final String divisionCode; //서버 내 코드 구분 값
    private final String message; //에러 코드 메시지

    private ErrorCode(int status, String divisionCode, String message) {
        this.status = status;
        this.divisionCode = divisionCode;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public String getDivisionCode() {
        return divisionCode;
    }


}
