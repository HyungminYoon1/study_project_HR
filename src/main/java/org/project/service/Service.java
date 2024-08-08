package org.project.service;

import org.project.connect.JDBCConnect;
import org.project.dto.AttendDto;
import org.project.dto.Employee;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Service extends JDBCConnect {
    private AttendDto attendDto;
    private BufferedReader br;
    private BufferedWriter bw;
    private StringBuffer response;

    public Service() {
        attendDto = new AttendDto();
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        response = new StringBuffer(500);
    }

    public void insert(){
        try {
            bw.write("직원 ID 입력");
            bw.flush();
            response.append(br.readLine());
            attendDto.setEmployeeId(response.toString());
            response.delete(0,response.length());
            bw.write("날짜입력 (YYYY-MM-DD) : ");
            bw.flush();
            response.append(br.readLine());
            attendDto.setWorkDate(response.toString());
            response.delete(0,response.length());
            bw.write("근무 상태 입력 [출근/결근/휴가/병가/연차]");
            bw.flush();
            response.append(br.readLine());
            attendDto.setCommuteId(response.toString());
            response.delete(0,response.length());
            response.append("insert into ATTENDS VALUES('ATTEND_SEQ.NEXTVAL',?,?,?)") ;
            PreparedStatement pstmt = conn.prepareStatement(response.toString());
            pstmt.setString(1,attendDto.getEmployeeId());
            pstmt.setString(2,attendDto.getWorkDate());
            pstmt.setString(3,attendDto.getCommuteId());
            pstmt.executeUpdate();
            response.delete(0,response.length());
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
        System.out.println("delete");
    }
    public void viewMonthlyWorkingStatusEmployee(){
        System.out.println("viewmonthE");
    }
    public void viewMonthlyWorkingStatusDepartment(){
        System.out.println("viewMothD");
    }


}
