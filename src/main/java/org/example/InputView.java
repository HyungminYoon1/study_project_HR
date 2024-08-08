package org.example;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);
    private final InputValueHandler inputValueHandler = new InputValueHandler();

    public int getOption() {
        System.out.println("--------- SELECT OPTIONS -----------");
        System.out.println("옵션을 선택하세요: ");
        System.out.print("숫자(0~10) 입력 >> ");
        return inputValueHandler.optionValidate(scanner.nextLine());
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
        return inputValueHandler.optionValidate(scanner.nextLine());
    }

    public void getTitleInputWorkingStatus() {
        System.out.println("==== 근태 입력 ====");
    }

    public String getEmployeeId(){
        System.out.print("직원 ID 입력: [EX: 12345] >> ");
        String employeeId = scanner.next();
        return employeeId;
    }

    public String getDate(){
        System.out.print("날짜 입력 (YYYY-MM-DD): [EX: 2024-08-01] >> ");
        String date = scanner.next();
        return date;
    }

    public String getWorkingStatus(){
        System.out.print("근무 상태 입력 (출근/퇴근/휴가 등): [EX: 출근] >> ");
        String workStatus = scanner.next();
        return workStatus;
    }
}
