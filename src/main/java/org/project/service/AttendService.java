package org.project.service;

import org.project.dto.*;
import org.project.utils.Messages;
import org.project.utils.OutputView;
import org.project.connect.JDBCConnect;
import org.project.utils.InputView;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AttendService extends JDBCConnect {
    private AttendDto attendDto;
    private SelectDto selectDto;
    private StringBuffer response;
    private InputView inputView;
    private OutputView outputView;
    private int count =0;
    private int notWorked =0;
    private int workRate = 0;
    public AttendService() {
        attendDto = new AttendDto();
        selectDto = new SelectDto();
        response = new StringBuffer(500);
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void insert(){
        try {
            response.append(inputView.getEmployeeIdBf());
            attendDto.setEmployeeId(response.toString());
            response.delete(0,response.length());
            response.append(inputView.getWorkDateBf());
            attendDto.setWorkDate(response.toString());
            response.delete(0,response.length());
            response.append(inputView.getWorkingStatusBf());
            attendDto.setCommuteId(response.toString());
            response.delete(0,response.length());
            String sql = "INSERT INTO ATTENDS (EMPLOYEE_FK, WORKDATE, COMMUTE_FK) VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,attendDto.getEmployeeId());
            pstmt.setString(2,attendDto.getWorkDate());
            pstmt.setString(3,attendDto.getCommuteId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(){
        try {
            response.append(inputView.getEmployeeIdBf());
            attendDto.setEmployeeId(response.toString());
            response.delete(0,response.length());
            response.append(inputView.getWorkDateBf());
            attendDto.setWorkDate(response.toString());
            response.delete(0,response.length());
            response.append(inputView.getWorkingStatusBf());
            attendDto.setCommuteId(response.toString());
            response.delete(0,response.length());
            String sql = "UPDATE ATTENDS SET COMMUTE_FK = ? WHERE EMPLOYEE_FK = ? AND WORKDATE = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,attendDto.getCommuteId());
            pstmt.setString(2,attendDto.getEmployeeId());
            pstmt.setString(3,attendDto.getWorkDate());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void delete(){
        String employeeId = inputView.getEmployeeId();
        String date = inputView.getDate();
        while(date.equals(Messages.WRONG_INPUT.getMessage())){
            date = inputView.getDate();
        }
        String sql = "DELETE FROM ATTENDS WHERE EMPLOYEE_FK=? and WORKDATE=? ";
        PreparedStatement pstmt;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, employeeId);
            pstmt.setString(2, date);
            pstmt.executeUpdate();
            pstmt.close();
            outputView.DisplaySuccessDeletingWorkingStatusData(employeeId, date);
        } catch (SQLException e) {
            outputView.DisplayNoWorkingStatusData(employeeId, date);
        }
    }

    public void viewMonthlyWorkingStatusEmployee(){
        HashMap<String, Object> row = new HashMap<>();
        try {
            String month = inputView.getMonth();
            while(month.equals(Messages.WRONG_INPUT.getMessage())){
                month = inputView.getMonth();
            }
            response.append(month);
            selectDto.setSelectWorkMonth(response.toString());
            response.delete(0,response.length());
            response.append(inputView.getEmployeeId());
            selectDto.setSelectEmployee(response.toString());
            response.delete(0,response.length());
            String sql =
                    "SELECT E.EMPLOYEE_NAME AS 사원명,  A.WORKDATE AS '근무일', C.COMMUTE_NAME AS '현황'\n" +
                    "FROM EMPLOYEES E\n" +
                    "JOIN DEPARTMENTS D ON E.DEPARTMENT_FK = D.DEPARTMENT_PK\n" +
                    "JOIN ATTENDS A ON E.EMPLOYEE_PK = A.EMPLOYEE_FK\n" +
                    "JOIN COMMUTES C ON A.COMMUTE_FK = C.COMMUTE_PK\n" +
                    "WHERE E.EMPLOYEE_PK = ? AND A.WORKDATE LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,selectDto.getSelectEmployee());
            pstmt.setString(2,"%"+selectDto.getSelectWorkMonth()+"%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String column1 = rs.getString("사원명");
                String column2 = rs.getString("근무일");
                String column3 = rs.getString("현황");

                row.put("사원명", column1);
                row.put("근무일", column2);
                row.put("현황", column3);
                System.out.println(row);
                count++;
            }
            System.out.println("출근일수 : " +count + "일");
            workRate = count*100/24;
            System.out.println("결근일 : " + (24-count)+"일");
            System.out.println("출근율" + workRate + "%");
            count=0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void viewMonthlyWorkingStatusEmployees(String employeeId,String workMonth){
        Map<String, String>employeeMap = new HashMap<>();
        String employeName = getEmployeeName(employeeId);
        try {
            String sql =
                    "SELECT E.EMPLOYEE_NAME AS 사원명,  A.WORKDATE AS '근무일', C.COMMUTE_NAME AS '현황'\n" +
                            "FROM EMPLOYEES E\n" +
                            "JOIN DEPARTMENTS D ON E.DEPARTMENT_FK = D.DEPARTMENT_PK\n" +
                            "JOIN ATTENDS A ON E.EMPLOYEE_PK = A.EMPLOYEE_FK\n" +
                            "JOIN COMMUTES C ON A.COMMUTE_FK = C.COMMUTE_PK\n" +
                            "WHERE E.EMPLOYEE_PK = ? AND A.WORKDATE LIKE ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,employeeId);
            pstmt.setString(2,"%"+workMonth+"%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String column1 = rs.getString("사원명");
                employeeMap.put(column1,column1);
                count++;
            }
            for(int i=0; i<employeeMap.size();i++){
                System.out.println(employeName);
            }
            System.out.println("출근일수 : " +count + "일");
            workRate = count*100/24;
            System.out.println("결근일 : " + (24-count)+"일");
            System.out.println("출근율" + workRate + "%");
            count=0;
            workRate=0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDepartmentName(String departmentId) {
        String sql = "SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE DEPARTMENT_PK = ?";
        PreparedStatement pstmt;
        String departmentName = "";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, departmentId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                departmentName = rs.getString("DEPARTMENT_NAME");
            }
        } catch (SQLException e) {
            return Messages.NONE_DEPARTMENT.getMessage();
        }
        return departmentName;
    }
    public String getEmployeeName(String employeeId) {
        String sql = "SELECT EMPLOYEE_NAME FROM EMPLOYEES WHERE EMPLOYEE_PK = ?";
        PreparedStatement pstmt;
        String employeeName = "";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, employeeId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                employeeName = rs.getString("EMPLOYEE_NAME");
            }
        } catch (SQLException e) {
            return Messages.NONE_EMPLOYEE.getMessage();
        }
        return employeeName;
    }
    public void viewMonthlyWorkingStatusDepartment(){
        List <String> employeeList = new ArrayList<>();
        // 작성중
        String departmentId = inputView.getDepartmentId();
        String departmentName = getDepartmentName(departmentId);
        System.out.println("부서 :" + departmentName);

        response.append(inputView.getMonth());
        selectDto.setSelectWorkMonth(response.toString());
        response.delete(0,response.length());

        try {
        String sql = "SELECT * FROM EMPLOYEES WHERE DEPARTMENT_FK = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,departmentId);
            rs=pstmt.executeQuery();
                while(rs.next()){
                    String employeeId = rs.getString("EMPLOYEE_PK");
                    employeeList.add(employeeId);
                }
                for(int i=0; i<employeeList.size(); i++){
                    viewMonthlyWorkingStatusEmployees(employeeList.get(i),selectDto.getSelectWorkMonth());
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
