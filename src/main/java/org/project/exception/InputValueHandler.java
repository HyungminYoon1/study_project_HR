package org.project.exception;

import org.project.option.AttendManageOption;
import org.project.option.MainOptions;
import org.project.option.WorkingStatus;
import org.project.utils.Messages;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputValueHandler {

    public int optionValidate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return MainOptions.INCORRECT.getNumber();
        }
    }

    public String dateFormValidate(String inputString) {
        if (inputString.equals(String.valueOf(AttendManageOption.TO_MAIN.getNumber()))) { // 입력취소
            throw new InputValidationException(Messages.GO_BACK.getMessage());
        }
        try {
            LocalDate.parse(inputString, DateTimeFormatter.ofPattern("yyyy-MM-dd")); // 문자열을 LocalDate로 변환 시도
            return inputString;
        } catch (DateTimeParseException e) { // 잘못된 날짜 입력
            if (inputString.isBlank()) {
                System.out.println(Messages.PLEASE_INPUT_DATE.getMessage()); // 날짜 미입력
            }else {
                System.out.println(Messages.WRONG_DATE_INPUT_TRY_AGAIN.getMessage());
            }
            return Messages.WRONG_INPUT.getMessage();
        }
    }

    public String monthFormValidate(String inputString) {
        if (inputString.equals(String.valueOf(AttendManageOption.TO_MAIN.getNumber()))) { // 입력취소
            throw new InputValidationException(Messages.GO_BACK.getMessage());
        }
        try {
            YearMonth.parse(inputString, DateTimeFormatter.ofPattern("yyyy-MM")); // 문자열을 LocalDate로 변환 시도
            return inputString;
        } catch (DateTimeParseException e) { // 잘못된 날짜 입력
            if (inputString.isBlank()) {
                System.out.println(Messages.PLEASE_INPUT_DATE.getMessage()); // 날짜 미입력
            }else {
                System.out.println(Messages.WRONG_DATE_INPUT_TRY_AGAIN.getMessage());
            }
            return Messages.WRONG_INPUT.getMessage();
        }
    }

    public String workingStatusValidate(String inputString) {
        if (inputString.equals(String.valueOf(AttendManageOption.TO_MAIN.getNumber()))) { // 입력취소
            throw new InputValidationException(Messages.GO_BACK.getMessage());
        }
        String revisedInputStr = WorkingStatus.fromInput(inputString).getWorkingStatusStr();
        if(inputString.equals( revisedInputStr )) {
            return inputString;
        }
        return WorkingStatus.ERROR.getWorkingStatusStr();
    }
}
