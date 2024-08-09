package org.project.utils;

import org.project.dto.Department;
import org.project.dto.Employee;
import org.project.utils.Messages;

import java.util.Scanner;

public class OutputView {

    private final Scanner scanner = new Scanner(System.in);

    public void displaySelectMainOptions(){
        System.out.println("==== 인적 자원 관리 시스템 ====\n" +
                "\n" +
                "1. 조직/직무 관리\n" +
                "2. 인사행정\n" +
                "3. 근태 관리 *\n" +
                "4. 급여/정산\n" +
                "5. 사회보험\n" +
                "6. 평가 관리\n" +
                "7. 연말정산\n" +
                "8. 승진 관리\n" +
                "9. 핵심 인재 관리\n" +
                "10. 월별 종합 현황 보기\n" +
                "0. 종료 *\n");
    }

    public void displayEmployeeMonthlyWorkingStatus(Employee employee) {
        System.out.println("==== 직원별 월별 근태 현황 ====");
        System.out.print("직원 ID: ");
        employee.getEmployeeId();
        System.out.print("이름: ");
        employee.getName();
        System.out.println("부서: ");
        employee.getDepartmentId();
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
    public void displayDepartmentMonthlyWorkingStatus(Department department) {
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


    public void displayProgramExit() {
        System.out.println("===== 프로그램 종료 =====");
    }

    public void reportMessage(Messages message) {

    }

    public void reportString(String message) {
    }

    public void DisplayNoWorkingStatusData(String employeeId, String date) {
        System.out.println("해당직원("+employeeId+")의 지정된 날짜("+date+")로 입력된 근무 정보가 없습니다.");
    }

    public void DisplayNoMonthlyWorkingStatusData(String departmentId, String month) {
        System.out.println("해당부서("+departmentId+")의 지정된 월("+month+")로 조회된 정보가 없습니다.");
    }

    public void DisplaySuccessDeletingWorkingStatusData(String employeeId, String date) {
        System.out.println("삭제 성공: 해당직원("+employeeId+")의 지정된 날짜("+date+")로 입력된 근무 정보를 삭제하였습니다.");
    }
}
