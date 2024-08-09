package org.project.service;

import org.project.utils.OutputView;
import org.project.connect.JDBCConnect;
import org.project.dto.AttendDto;
import org.project.dto.SelectDto;
import org.project.utils.InputView;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public final class AttendService extends JDBCConnect {
    private AttendDto attendDto;
    private SelectDto selectDto;
    private BufferedReader br;
    private BufferedWriter bw;
    private StringBuffer response;
    private InputView inputView;
    private OutputView outputView;

    public AttendService() {
        attendDto = new AttendDto();
        selectDto = new SelectDto();
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        response = new StringBuffer(500);
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void insert(){
        try {
            response.append(inputView.getEmployeeIdBf());
            attendDto.setEmployeeId(response.toString());
            response.delete(0,response.length());
            response.append(inputView.getDateBf());
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
            response.append(inputView.getDateBf());
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
        System.out.println("delete"); // hmyoon 작성
    }

    public void viewMonthlyWorkingStatusEmployee(){
        try {
            response.append(inputView.getDateBf());
            selectDto.setSelectWorkDate(response.toString());
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
            pstmt.setString(2,"%"+selectDto.getSelectWorkDate()+"%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String column1 = rs.getString("사원명");
                String column2 = rs.getString("근무일");
                String column3 = rs.getString("현황");

                HashMap<String, Object> row = new HashMap<>();
                row.put("사원명", column1);
                row.put("근무일", column2);
                row.put("현황", column3);
                System.out.println(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void viewMonthlyWorkingStatusDepartment(){
        System.out.println("viewMothD"); // hmyoon 작성
    }


}
