package org.project.dto;

import org.project.Status;

public class AttendDto {
    private String attendId;
    private String employeeId;
    private String CommuteId;
    private String workDate;

    public String getAttendId() {
        return attendId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getCommuteId() {
        return CommuteId;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setCommuteId(String commuteId) {
        CommuteId = commuteId;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }
}
