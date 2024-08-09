package org.project.dto;

public class PersonalWorkingViewDto {
    private String employeeName;
    private int rate ;
    private int workDay;
    private int notWorkDay;
    private int vacationDay;

    public String getEmployeeName() {
        return employeeName;
    }

    public int getRate() {
        return rate;
    }

    public int getWorkDay() {
        return workDay;
    }

    public int getNotWorkDay() {
        return notWorkDay;
    }

    public int getVacationDay() {
        return vacationDay;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public void setNotWorkDay(int notWorkDay) {
        this.notWorkDay = notWorkDay;
    }

    public void setVacationDay(int vacationDay) {
        this.vacationDay = vacationDay;
    }
}
