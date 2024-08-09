package org.project.service;

import org.project.connect.JDBCConnect;
import org.project.dto.AttendDto;
import org.project.dto.Employee;
import org.project.dto.SelectDto;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class Service extends JDBCConnect {
    private AttendDto attendDto;
    private SelectDto selectDto;
    private BufferedReader br;
    private BufferedWriter bw;
    private StringBuffer response;

    public Service() {
        attendDto = new AttendDto();
        selectDto = new SelectDto();
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
            String sql = "INSERT INTO ATTENDS (EMPLOYEE_FK, WORKDATE, COMMUTE_FK) VALUES(?,?,?)";
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
        try {
            bw.write("수정할 직원ID를 입력해 주세요");
            bw.flush();
            response.append(br.readLine());
            attendDto.setEmployeeId(response.toString());
            response.delete(0,response.length());
            bw.write("수정할 날짜를 입력해 주세요 ex) 2024-08-01");
            bw.flush();
            response.append(br.readLine());
            attendDto.setWorkDate(response.toString());
            response.delete(0,response.length());
            bw.write("수정할 상태를 입력해 주세요 ex)출근/결근/휴가/병가/연차");
            bw.flush();
            response.append(br.readLine());
            attendDto.setCommuteId(response.toString());
            response.delete(0,response.length());
            String sql = "UPDATE ATTENDS SET COMMUTE_FK = ? WHERE EMPLOYEE_FK = ? AND WORKDATE = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,attendDto.getCommuteId());
            pstmt.setString(2,attendDto.getEmployeeId());
            pstmt.setString(3,attendDto.getWorkDate());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void delete(){
        System.out.println("delete");
    }
    public void viewMonthlyWorkingStatusEmployee(){
        try {
            bw.write("조회할 날짜를 입력해 주세요 EX)2024-08");
            bw.flush();
            response.append(br.readLine());
            selectDto.setSelectWorkDate(response.toString());
            response.delete(0,response.length());
            bw.write("조회할 직원ID를 입력해 주세요 ");
            bw.flush();
            response.append(br.readLine());
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

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void viewMonthlyWorkingStatusDepartment(){
        System.out.println("viewMothD");
    }


}
