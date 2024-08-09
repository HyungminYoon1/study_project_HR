package org.project;

public enum Messages {

    WRONG_INPUT_TRY_AGAIN("$ 잘못된 입력. 다시 시도해주세요."),
    WRONG_DATE_INPUT_TRY_AGAIN("$ 잘못된 날짜 입력. 다시 시도해주세요."),
    UNEXPECTED_ERROR("$ 알 수 없는 오류!"),
    GO_BACK("이전단계로 이동."),
    CANCEL_RESTART("취소. 재시작"),
    SELECT("선택하세요: "),
    PLEASE_INPUT_DATE("날짜를 입력하세요"),
    WRONG_INPUT("잘못된 입력"),
    NONE_DEPARTMENT("해당 부서가 존재하지않습니다.");

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
