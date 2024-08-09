package org.project.dto;

public class SelectDto {
    private String selectEmployee;
    private String selectDepartment;
    private String selectWorkDate;

    public String getSelectWorkDate() {
        return selectWorkDate;
    }

    public String getSelectEmployee() {
        return selectEmployee;
    }

    public String getSelectDepartment() {
        return selectDepartment;
    }

    public void setSelectWorkDate(String selectWorkDate) {
        this.selectWorkDate = selectWorkDate;
    }

    public void setSelectEmployee(String selectEmployee) {
        this.selectEmployee = selectEmployee;
    }

    public void setSelectDepartment(String selectDepartment) {
        this.selectDepartment = selectDepartment;
    }
}
