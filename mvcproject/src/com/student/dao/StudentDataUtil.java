package com.student.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.entity.StudentEntity;

public class StudentDataUtil {
	
	public static List<StudentEntity> getStudents() {
		
		
		List<StudentEntity> students = new ArrayList<StudentEntity>();
		StudentEntity student = null;
		
		Connection conn = ConfigureImpl.getConnObject();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select firstname, lastname, adress\r\n" + 
				"from studentinfo";
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				student = new StudentEntity();
				student.setsFirstName(rs.getString(1));
				student.setsLastName(rs.getString(2));
				student.setsAdress(rs.getString(3));
				
				students.add(student);
			}
			
			rs.close();
			stmt.close();
			ConfigureImpl.closeConn();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return students;
	}

}
