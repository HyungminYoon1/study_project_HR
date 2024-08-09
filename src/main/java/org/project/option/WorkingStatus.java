package org.project.option;

public enum WorkingStatus {

    ERROR("잘못된 입력"),
    UNKNOWN("알 수 없는 근무상태"),
    EMPTY("미입력"),
    ON_WORK("출근"),
    DAY_OFF("휴무"),
    MORNING_OFF("오후근무"),
    AFTERNOON_OFF("오전근무"),
    NIGHT_DUTY("야간근무"),
    VACATION("휴가"),
    ABSENCE("결근"),
    MISSING("실종")
    ;


    private final String workingStatusStr;

    WorkingStatus(String status) {
        this.workingStatusStr = status;
    }

    public String getWorkingStatusStr() {
        return workingStatusStr;
    }

    public static WorkingStatus fromInput(String inputValue) {
        for (WorkingStatus status : WorkingStatus.values()) {
            if (status.getWorkingStatusStr().equals(inputValue)) {
                return status;
            }
        }
        return ERROR;
    }
}
