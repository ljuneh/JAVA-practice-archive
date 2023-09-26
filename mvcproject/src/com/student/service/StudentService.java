package com.student.service;

import java.util.ArrayList;
import java.util.List;

import com.student.dao.StudentDataUtil;
import com.student.dto.StudentDto;
import com.student.entity.StudentEntity;

public class StudentService {
	public static List<StudentDto> getStudents() {
		String driver = "oracle.jdbc.driver.OracleDriver";
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
		List<StudentEntity> studentEntityList = StudentDataUtil.getStudents();
		
		List<StudentDto> students = new ArrayList<StudentDto>();
		
		for(StudentEntity se: studentEntityList) {
			StudentDto stdto = new StudentDto();
			stdto.setsName(se.getsLastName()+se.getsFirstName());
			if(se.getsAdress().contains("서울")) {
				stdto.setsRegionType("서울");
			} else {
				stdto.setsRegionType("비서울");
			}
			
			students.add(stdto);
		}
			
		return students;
	}

}
