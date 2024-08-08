package org.project.option;

public enum AttendManageOption {
    INCORRECT(-1),
    INSERT_ATTEND(1),
    UPDATE_ATTEND(2),
    DELETE_ATTEND(3),
    VIEW_MONTHLY_WORKING_STATUS_EMPLOYEES(4),
    VIEW_MONTHLY_WORKING_STATUS_DEPARTMENTS(5),
    TO_MAIN(0);

    final int attendOption;
    AttendManageOption(int attendOption) {
        this.attendOption = attendOption;
    }

    public static AttendManageOption fromInput(int inputValue) {
        for (AttendManageOption option : AttendManageOption.values()) {
            if (option.getNumber() == inputValue) {
                return option;
            }
        }
        return INCORRECT;
    }

    private int getNumber() {
        return attendOption;
    }
}
