package org.project.dto;

public class Employee {

    String employeeId;
    String name;
    String departmentId;


    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
