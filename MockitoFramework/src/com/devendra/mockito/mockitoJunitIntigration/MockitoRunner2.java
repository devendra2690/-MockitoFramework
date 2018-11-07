package com.devendra.mockito.mockitoJunitIntigration;

import static org.mockito.Mockito.spy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * 
 * Difference between a Spy and a Mock

When Mockito creates a mock – it does so from the Class of a Type, not from an actual instance. The mock simply creates a bare-bones shell instance of the Class, entirely instrumented to track interactions with it. On the other hand, the spy will wrap an existing instance. It will still behave in the same way as the normal instance – the only difference is that it will also be instrumented to track all the interactions with it.

In the following example – we create a mock of the ArrayList class:

@Test
public void whenCreateMock_thenCreated() {
    List mockedList = Mockito.mock(ArrayList.class);

    mockedList.add("one");
    Mockito.verify(mockedList).add("one");

    assertEquals(0, mockedList.size());
}
As you can see – adding an element into the mocked list doesn’t actually add anything – it just calls the method with no other side-effect. A spy on the other hand will behave differently – it will actually call the real implementation of the add method and add the element to the underlying list:

@Test
public void whenCreateSpy_thenCreate() {
    List spyList = Mockito.spy(new ArrayList());
    spyList.add("one");
    Mockito.verify(spyList).add("one");

    assertEquals(1, spyList.size());
}
Here we can surely say that the real internal method of the object was called because when you call the size() method you get the size as 1, but this size() method isn’t been mocked! So where does 1 come from? The internal real size() method is called as size() isn’t mocked (or stubbed) and hence we can say that the entry was added to the real object.
 * 
 * @author dpatil
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoRunner2 {

	private CalculationServiceImpl calculationServiceImpl;
	private CalculationService calculationService;
	
	@Before
	public void setup() {
		
		calculationServiceImpl = new CalculationServiceImpl();
		Calculator calculator = new Calculator();
		calculationService = spy(calculator);
		calculationServiceImpl.setCalculatorService(calculator);
	}
	
	@Test
	public void spyObj() {
		Assert.assertEquals(Double.valueOf(String.valueOf(calculationServiceImpl.add(20, 30))),Double.valueOf(String.valueOf(50)));
	}
	
	public class Calculator implements CalculationService{

		@Override
		public int add(int value1, int value2) {
            System.out.println("Spying is working");
			return value1 + value2;
		}

		@Override
		public int sub(int value1, int value2) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int multiply(int value1, int value2) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int divide(int value1, int value2) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}
