package com.devendra.mockito.mockitoJunitIntigration;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JunitRunner {

	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(MockitoRunner.class);
		 for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      
		 if(result.wasSuccessful()) {
			 
		      System.out.println("All test case passed Successfully");
		 }else{
		      System.out.println("Some of test case might failed");
		 }
		 
		 
		 result = JUnitCore.runClasses(MockitoRunner2.class);
		 for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      
		 if(result.wasSuccessful()) {
			 
		      System.out.println("All test case passed Successfully");
		 }else{
		      System.out.println("Some of test case might failed");
		 }
	}
}
