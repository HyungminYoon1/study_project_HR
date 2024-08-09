package org.project.service;

import org.project.InputView;
import org.project.OutputView;
import org.project.connect.JDBCConnect;
import org.project.dto.AttendDto;
import org.project.dto.Employee;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class Service extends JDBCConnect {
    private AttendDto attendDto;
    private BufferedReader br;
    private BufferedWriter bw;
    private StringBuffer response;
    private InputView inputView;
    private OutputView outputView;

    public Service() {
        attendDto = new AttendDto();
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        response = new StringBuffer(500);
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void insert(){
        try {
            bw.write("직원 ID 입력");
            bw.flush();
            response.append(br.readLine());
            attendDto.setEmployeeId(response.toString());
            System.out.println(attendDto.getEmployeeId());
            response.delete(0,response.length());
            bw.write("날짜입력 (YYYY-MM-DD) : ");
            bw.flush();
            response.append(br.readLine());
            attendDto.setWorkDate(response.toString());
            System.out.println(attendDto.getWorkDate());
            response.delete(0,response.length());
            bw.write("근무 상태 입력 [출근/결근/휴가/병가/연차]");
            bw.flush();
            response.append(br.readLine());
            attendDto.setCommuteId(response.toString());
            System.out.println(attendDto.getCommuteId());
            response.delete(0,response.length());
            System.out.println(attendDto.getEmployeeId()+attendDto.getWorkDate()+attendDto.getCommuteId());
            String sql = "INSERT INTO ATTENDS VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,attendDto.getEmployeeId());
            pstmt.setString(2,attendDto.getWorkDate());
            pstmt.setString(3,attendDto.getCommuteId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(){
        System.out.println("update");
    }
    public void delete(){
        String employeeId = inputView.getEmployeeId();
        String date = inputView.getDate();
        String sql = "DELETE FROM ATTENDS WHERE EMPLOYEEID=? and DATE=? ";
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
        System.out.println("viewmonthE");
    }
    public void viewMonthlyWorkingStatusDepartment(){
        System.out.println("viewMothD"); // hmyoon 작성
    }


}
