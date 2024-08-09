package org.project.controller;

import org.project.exception.InputValidationException;
import org.project.option.AttendManageOption;
import org.project.option.MainOptions;
import org.project.service.AttendService;
import org.project.utils.InputView;
import org.project.utils.Messages;
import org.project.utils.OutputView;

public class Controller {

    private AttendService service;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        service= new AttendService();
        boolean running = true;
        outputView.displaySelectMainOptions();
        while (running) {
            MainOptions option = MainOptions.fromInput(inputView.getOption());
            try {
                switch (option) {
                    case INPUT_CANCEL_GO_BACK:
                        outputView.reportMessage(Messages.CANCEL_RESTART);
                        break;
                    case ORGANIZATION_JOB_MANAGEMENT:
                        // 미구현
                        break;
                    case PERSONNEL_ADMINISTRATION:
                        // 미구현;
                        break;
                    case EMPLOYMENT_WORKING_STATUS_MANAGEMENT:
                        // 미구현'
                        AttendManageOption attendManageOption = AttendManageOption.fromInput(inputView.getEmploymentStatusOptions());
                        switch (attendManageOption){
                            case INCORRECT :
                                break;
                            case INSERT_ATTEND:
                                service.insert();
                                break;
                            case UPDATE_ATTEND:
                                service.update();
                                break;
                            case DELETE_ATTEND:
                                service.delete();
                                break;
                            case VIEW_MONTHLY_WORKING_STATUS_EMPLOYEES:
                                service.viewMonthlyWorkingStatusEmployee();
                                break;
                            case VIEW_MONTHLY_WORKING_STATUS_DEPARTMENTS:
                                service.viewMonthlyWorkingStatusDepartment();
                                break;
                            case TO_MAIN:
                                break;
                        }
                    case PAYROLL_SETTLEMENT:
                        //미구현
                        break;
                    case SOCIAL_INSURANCE:
                        //미구현
                        break;
                    case ASSESSMENT_MANAGEMENT:
                        //미구현
                        break;
                    case YEAR_END_TAX_ADJUSTMENT:
                        //미구현
                        break;
                    case PROMOTION_MANAGEMENT:
                        //미구현
                        break;
                    case IMPORTANT_MEMBERS_MANAGEMENT:
                        //미구현
                        break;
                    case MONTHLY_STATUS_SUMMURY:
                        //미구현
                        break;
                    case EXIT:
                        running = false;
                        outputView.displayProgramExit();
                        break;
                    default:
                        outputView.reportMessage(Messages.WRONG_INPUT_TRY_AGAIN);
                        break;
                }
            } catch (InputValidationException e) {
                outputView.reportString(e.getMessage());
            }
            catch (Exception e) {
                outputView.reportMessage(Messages.UNEXPECTED_ERROR);
            }
        }
    }

}
