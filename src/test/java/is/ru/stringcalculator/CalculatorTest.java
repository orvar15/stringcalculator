package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
		assertEquals(2, Calculator.add("2"));
		assertEquals(3, Calculator.add("3"));
		assertEquals(4, Calculator.add("4"));
		assertEquals(5, Calculator.add("5"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
		assertEquals(4, Calculator.add("2,2"));
		assertEquals(6, Calculator.add("3,3"));
		assertEquals(8, Calculator.add("4,4"));
		assertEquals(10, Calculator.add("5,5"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(3, Calculator.add("1,1,1"));
    	assertEquals(6, Calculator.add("1,2,3"));
    	assertEquals(8, Calculator.add("3,2,3"));
    	assertEquals(10, Calculator.add("5,2,3"));
    	assertEquals(12, Calculator.add("1,1,10"));
    }

}