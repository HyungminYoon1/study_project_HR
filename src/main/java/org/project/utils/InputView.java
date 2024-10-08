package org.project.utils;

import org.project.exception.InputValueHandler;

import java.io.*;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private StringBuffer response = new StringBuffer(500);
    private final InputValueHandler inputValueHandler = new InputValueHandler();

    public int getOption() {
        System.out.println("--------- SELECT OPTIONS -----------");
        System.out.println("옵션을 선택하세요: ");
        System.out.print("숫자(0~10) 입력 >> ");
        return inputValueHandler.optionValidate(scanner.next());
    }

    public int getEmploymentStatusOptions(){
        System.out.println("==== 근태 관리 ====\n" +
                "\n" +
                "1. 근태 입력 (option)\n" +
                "2. 근태 수정 *\n" +
                "3. 근태 삭제 *\n" +
                "4. 직원별 월별 근태 현황 보기 (option)\n" +
                "5. 부서별 월별 근태 현황 보기 *\n" +
                "0. 메인 메뉴로 돌아가기 *\n");
        System.out.print("선택하세요: ");
        return inputValueHandler.optionValidate(scanner.next());
    }

    public void getTitleInputWorkingStatus() {
        System.out.println("==== 근태 입력 ====");
    }

    public String getEmployeeId(){
        System.out.print("직원 ID 입력: [EX: 12345] >> ");
        String employeeId = scanner.next();
        return "EMPLOYEE_"+employeeId;
    }
    public String getEmployeeIdBf(){
        try {
            response.delete(0,response.length());
            bw.write("직원 ID 입력: [EX: 01] >> ");
            bw.flush();
            response.append(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "EMPLOYEE_"+response.toString();
    }
    public String getWorkDateBf(){
        try {
            response.delete(0,response.length());
            bw.write("날짜 입력 (YYYY-MM-DD): [EX: 2024-08-01] >> ");
            bw.flush();
            response.append(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inputValueHandler.dateFormValidate(response.toString());
    }
    public String getWorkMonthBf(){
        try {
            response.delete(0,response.length());
            bw.write("날짜 입력 (YYYY-MM): [EX: 2024-08] ");
            bw.flush();
            response.append(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response.toString();
    }
    public String getWorkingStatusBf(){
        try {
            response.delete(0,response.length());
            bw.write("근무 상태 입력 [EX: 출근 = 01 /결근 = 02/휴가 = 03/병가 = 04/연차 = 05]");
            bw.flush();
            response.append(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "COMMUTE_"+response.toString();
    }

    public String getMonth(){
        System.out.print("날짜 입력 (YYYY-MM): [EX: 2024-08] >> ");
        String month = scanner.next();
        return inputValueHandler.monthFormValidate(month);
    }

    public String getDate(){
        System.out.print("날짜 입력 (YYYY-MM-DD): [EX: 2024-08-01] >> ");
        String date = scanner.next();
        return inputValueHandler.dateFormValidate(date);
    }

    public String getWorkingStatus(){
        System.out.print("근무 상태 입력 (출근/퇴근/휴가 등): [EX: 출근] >> ");
        String workStatus = scanner.next();
        return inputValueHandler.workingStatusValidate(workStatus);
    }

    public String getDepartmentId() {
        System.out.println("부서 아이디를 입력: [EX: 01] >> ");
        String departmentId = scanner.next();
        return "DEPARTMENT_"+departmentId;
    }

}
