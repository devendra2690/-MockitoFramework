package com.devendra.mockito.serviceImpl;

import com.devendra.mockito.bean.Student;
import com.devendra.mockito.bean.Subject;
import com.devendra.mockito.service.StudentService;

public class StudentServiceImpl implements StudentService{

	@Override
	public String getGrade(int stdId) {

		System.out.println("Grades being calculated");
		return "C";
	}

	@Override
	public Integer calculateMarks(Student std) {

		System.out.println("Marks being calculated");
		return 650;
	}

	@Override
	public void addSubject(Subject subject) {

	   System.out.println("Subject Added Succesfully");	
	}	
}
