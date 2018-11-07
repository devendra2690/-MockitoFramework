package com.devendra.mockito.mockitoJunitIntigration;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.reset;




@RunWith(MockitoJUnitRunner.class)
public class MockitoRunner {

	@InjectMocks
	CalculationServiceImpl calculationServiceImpl = new CalculationServiceImpl();
	
	@Mock
	CalculationService calculationService;
	
	/**
	 * mock calculationservice
	 */
	@Test
	public void testCalculationService() {
		
		when(calculationService.add(20, 30)).thenReturn(50);
		when(calculationService.sub(30, 20)).thenReturn(10);	
		when(calculationService.multiply(5, 4)).thenReturn(20);	
		when(calculationService.divide(20, 4)).thenReturn(5);	
		
		Assert.assertEquals(Double.valueOf(String.valueOf(calculationServiceImpl.add(20, 30))),Double.valueOf(String.valueOf(50)));
		Assert.assertEquals(Double.valueOf(String.valueOf(calculationServiceImpl.sub(30, 20))),Double.valueOf(String.valueOf(10)));
		Assert.assertEquals(Double.valueOf(String.valueOf(calculationServiceImpl.multiply(5, 4))),Double.valueOf(String.valueOf(20)));
		Assert.assertEquals(Double.valueOf(String.valueOf(calculationServiceImpl.divide(20, 4))),Double.valueOf(String.valueOf(5)));
	}
	
	/**
	 * Test verify functionality if Mock
	 *  
	 *  Check arugment is passed correctly
	 */
	@Test
	public void verfiyAdd_Successful() {
		
		when(calculationService.add(20, 30)).thenReturn(50);
		Assert.assertEquals(Double.valueOf(String.valueOf(calculationServiceImpl.add(20, 30))),Double.valueOf(String.valueOf(50)));

		verify(calculationService).add(20, 30);
	}
	
	@Test
	public void verifyAdd_Failure() {
		
		when(calculationService.add(20, 30)).thenReturn(50);
		Assert.assertEquals(Double.valueOf(String.valueOf(calculationServiceImpl.add(20, 30))),Double.valueOf(String.valueOf(50)));

		verify(calculationService).add(20, 50);
	}
	
	
	/**
	 * Test verify functionality if Mock
	 * 
	 * check number of time call to service
	 * 
	 */
	@Test
	public void testVerify_Time_Success() {
		
		when(calculationService.add(20, 30)).thenReturn(50);
		Assert.assertEquals(Double.valueOf(String.valueOf(calculationServiceImpl.add(20, 30))),Double.valueOf(String.valueOf(50)));

		verify(calculationService, times(1)).add(20, 30);
		
	}
	
	@Test
	public void testVerify_Time_Failure() {
		
		when(calculationService.add(20, 30)).thenReturn(50);
		Assert.assertEquals(Double.valueOf(String.valueOf(calculationServiceImpl.add(20, 30))),Double.valueOf(String.valueOf(50)));
		Assert.assertEquals(Double.valueOf(String.valueOf(calculationServiceImpl.add(20, 30))),Double.valueOf(String.valueOf(50)));

		verify(calculationService, times(1)).add(20, 30);
	}
	
	/**
	 *  Test verify functionality if Mock
	 * 
	 *  never called service method
	 * 
	 */
	@Test
	public void testVerify_Never_Success() {
		
		when(calculationService.add(20, 30)).thenReturn(50);
		Assert.assertEquals(Double.valueOf(String.valueOf(calculationServiceImpl.add(20, 30))),Double.valueOf(String.valueOf(50)));

		verify(calculationService, times(1)).add(20, 30);
		
		verify(calculationService, never()).sub(20, 30);
	}
	
	/**
	 *  Test verify functionality if Mock
	 * 
	 *  never called service method
	 * 
	 */
	@Test
	public void testVerify_Never_Failure() {
		
		when(calculationService.add(20, 30)).thenReturn(50);
		Assert.assertEquals(Double.valueOf(String.valueOf(calculationServiceImpl.add(20, 30))),Double.valueOf(String.valueOf(50)));

		verify(calculationService, never()).add(20, 30);
	}
	
	/**
	 *  Test verify functionality if Mock
	 * 
	 * dpThrow
	 * 
	 */
	@Test
	public void testVerify_doThrow_Failure() {
		
		//add the behavior to throw exception
	      doThrow(new RuntimeException("Add operation not implemented"))
	         .when(calculationService).add(20, 30);

	      Assert.assertEquals(Double.valueOf(String.valueOf(calculationService.add(20, 30))),Double.valueOf(String.valueOf(50)));
	}	
	
	/**
	 *  Test verify functionality if Mock
	 * 
	 * dpThrow
	 * 
	 */
	@Test
	public void testVerify_InOrder_Success() {
		
		when(calculationService.add(20, 30)).thenReturn(50);
		when(calculationService.sub(30, 20)).thenReturn(10);	
		
		calculationServiceImpl.add(20, 30);
		calculationServiceImpl.sub(20, 30);
		
		//create an inOrder verifier for a single mock
		InOrder inOrder = inOrder(calculationService);

		//following will make sure that add is first called then subtract is called.
		inOrder.verify(calculationService).add(20,10);
		inOrder.verify(calculationService).sub(20,10);
	}	
	
	@Test
	public void testVerify_InOrder_Failure() {
		
		when(calculationService.add(20, 30)).thenReturn(50);
		when(calculationService.sub(20, 30)).thenReturn(10);	
		
		calculationServiceImpl.add(20, 30);
		calculationServiceImpl.sub(20, 30);
		
		//create an inOrder verifier for a single mock
		InOrder inOrder = inOrder(calculationService);

		//following will make sure that add is first called then subtract is called.
		inOrder.verify(calculationService).sub(20,30);
		inOrder.verify(calculationService).add(20,30);
	}
	
	/**
	 * Reset The mock Object
	 * 
	 */
	
	 @Test
	   public void testAddAndSubtract(){

	      //add the behavior to add numbers
			when(calculationService.add(20, 30)).thenReturn(50);
	  
	      //test the add functionality
			Assert.assertEquals(Double.valueOf(String.valueOf(calculationServiceImpl.add(20, 30))),Double.valueOf(String.valueOf(50)));

	      //reset the mock	  
	      reset(calculationService);

	      //test the add functionality after resetting the mock
		 Assert.assertEquals(Double.valueOf(String.valueOf(calculationServiceImpl.add(20, 30))),Double.valueOf(String.valueOf(50)));
	   }
}
