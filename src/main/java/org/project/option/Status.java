package org.project.option;

public enum Status {
    NORMAL("출근"),
    VACATION("휴가"),
    ABSENCE("결근");


    private final String statusStr;

    Status (String status) {
        this.statusStr = status;
    }

    public String getStatusStr() {
        return statusStr;
    }

}
