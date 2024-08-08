package org.example;

public enum Messages {

    WRONG_INPUT_TRY_AGAIN("$ 잘못된 입력. 다시 시도해주세요."),
    WRONG_DATE_INPUT_TRY_AGAIN("$ 잘못된 날짜 입력. 다시 시도해주세요."),
    UNEXPECTED_ERROR("$ 알 수 없는 오류!"),
    CANCEL_BACK("취소. 이전단계로 이동."),
    CANCEL_RESTART("취소. 재시작"),
    SELECT("선택하세요: ");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
