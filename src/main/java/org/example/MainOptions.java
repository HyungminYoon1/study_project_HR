package org.example;

public enum MainOptions {
    INCORRECT(-2),
    INPUT_CANCEL_GO_BACK(-1),
    ORGANIZATION_JOB_MANAGEMENT(1),
    PERSONNEL_ADMINISTRATION(2),
    EMPLOYMENT_WORKING_STATUS_MANAGEMENT(3),
    PAYROLL_SETTLEMENT(4),
    SOCIAL_INSURANCE(5),
    ASSESSMENT_MANAGEMENT(6),
    YEAR_END_TAX_ADJUSTMENT(7),
    PROMOTION_MANAGEMENT(8),
    IMPORTANT_MEMBERS_MANAGEMENT(9),
    MONTHLY_STATUS_SUMMURY(10),
    EXIT(0);


    private final int number;

    MainOptions(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static MainOptions fromInput(int inputValue) {
        for (MainOptions option : MainOptions.values()) {
            if (option.getNumber() == inputValue) {
                return option;
            }
        }
        return INCORRECT;
    }
}
