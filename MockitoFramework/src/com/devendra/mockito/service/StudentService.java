package com.devendra.mockito.service;

import com.devendra.mockito.bean.Student;
import com.devendra.mockito.bean.Subject;

public interface StudentService {

	public String getGrade(int stdId);
	public Integer calculateMarks(Student std);
	public void addSubject(Subject subject);
}
