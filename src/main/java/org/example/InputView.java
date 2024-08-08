package org.example;

import static org.example.OutputView.scanner;

public class InputView {

    private void displaySelectMainOptions(){
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

    private void displaySelectEmploymentStatusOptions(){
        System.out.println("==== 근태 관리 ====\n" +
                "\n" +
                "1. 근태 입력 (option)\n" +
                "2. 근태 수정 *\n" +
                "3. 근태 삭제 *\n" +
                "4. 직원별 월별 근태 현황 보기 (option)\n" +
                "5. 부서별 월별 근태 현황 보기 *\n" +
                "0. 메인 메뉴로 돌아가기 *\n");
    }

    private void displayTitleInputWorkingStatus() {
        System.out.println("==== 근태 입력 ====");
    }

    private String displayGetEmployeeId(){
        System.out.print("직원 ID 입력: [EX: 12345] >> ");
        String employeeId = scanner.next();
        return employeeId;
    }

    private String displayGetDate(){
        System.out.print("날짜 입력 (YYYY-MM-DD): [EX: 2024-08-01] >> ");
        String date = scanner.next();
        return date;
    }

    private String displayGetWorkingStatus(){
        System.out.print("근무 상태 입력 (출근/퇴근/휴가 등): [EX: 출근] >> ");
        String workStatus = scanner.next();
        return workStatus;
    }
}
