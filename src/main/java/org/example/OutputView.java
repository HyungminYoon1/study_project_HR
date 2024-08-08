package org.example;

import java.util.Scanner;

public class OutputView {

    static Scanner scanner = new Scanner(System.in);

    private void displayEmployeeMonthlyWorkingStatus(Employee employee) {
        System.out.println("==== 직원별 월별 근태 현황 ====");
        System.out.print("직원 ID: ");
        employee.getEmployeeId();
        System.out.print("이름: ");
        employee.getName();
        System.out.println("부서: ");
        employee.getDepartment();
        System.out.println("2024년 8월 근태 현황: ");

        // ********** 이하 구현 필요
        System.out.println("2024년 8월 근태 현황:\n" +
                "- 2024-08-01: 출근\n" +
                "- 2024-08-02: 출근\n" +
                "- 2024-08-03: 휴가\n" +
                "...\n" +
                "- 2024-08-31: 출근\n" +
                "\n" +
                "총 출근 일수: 22일\n" +
                "총 결근 일수: 1일\n" +
                "총 휴가 일수: 1일\n");
    }
    private void displayDepartmentMonthlyWorkingStatus(Department department) {
        System.out.println("==== 부서별 월별 근태 현황 ====");
        System.out.print("부서: ");
        department.getDepartmentName();

        System.out.print("2024년 8월 근태 현황: ");

        // ********** 이하 구현 필요
        System.out.println("- 직원 ID: 12345, 이름: 홍길동\n" +
                "  - 출근율 : 91%\n" +
                "  - 출근: 22일, 결근: 1일, 휴가: 1일\n" +
                "- 직원 ID: 67890, 이름: 이순신\n" +
                "  - 출근율 : 83%\n" +
                "  - 출근: 20일, 결근: 2일, 휴가: 1일\n" +
                "...\n");
    }


}
