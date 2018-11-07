package com.devendra.mockito.mockitoJunitIntigration;

public class CalculationServiceImpl {

	private CalculationService calculationService;
	
	public Integer add(int value1, int value2) {
		return calculationService.add(value1, value2);
	}

	public Integer sub(int value1, int value2) {
		return  calculationService.sub(value1, value2);
	}

	public Integer multiply(int value1, int value2) {
		return  calculationService.multiply(value1, value2);
	}

	public Integer divide(int value1, int value2) {
		return  calculationService.divide(value1, value2);
	}	
	
	public void setCalculatorService(CalculationService calcService){
	      this.calculationService = calcService;
	 }
}
