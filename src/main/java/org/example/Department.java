package org.example;

import java.util.Set;

public class Department {

    String departmentId;
    String departmentName;
    Set<Employee> members;



    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Set<Employee> getMembers() {
        return members;
    }
}
