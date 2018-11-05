package com.devendra.mockito.test;

import static org.mockito.Mockito.*;

import com.devendra.mockito.bean.Student;
import com.devendra.mockito.service.StudentService;

public class StudentServiceTest {

	StudentService studentService;
	
	public static void main(String[] args) {
		
		StudentServiceTest studentServiceTest = new StudentServiceTest();
		studentServiceTest.setUp();
	}
	
	public void setUp() {
		
		studentService = mock(StudentService.class);
		when(studentService.getGrade(anyInt())).thenReturn("N");
	    when(studentService.calculateMarks(any(Student.class))).thenReturn(999);	
	    
	    System.out.println(studentService.getGrade(11));
	    System.out.println(studentService.calculateMarks(new Student()));
	}
}
