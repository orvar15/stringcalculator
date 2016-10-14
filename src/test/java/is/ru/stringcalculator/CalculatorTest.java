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

    @Test 
    public void testWhenNumersAreSplitWithNewLine() {
    	assertEquals(3, Calculator.add("1,1\n1"));
    	assertEquals(4, Calculator.add("1,1\n2"));
    	assertEquals(6, Calculator.add("2\n2,2"));
    	assertEquals(8, Calculator.add("3,3\n2"));
    	assertEquals(10, Calculator.add("3\n3,4"));
    }

    @Test
    public void testNegativeNumbers() {
    	try {
    		Calculator.add("1,-2,2");
    		Calculator.add("-1,2,2");
    		Calculator.add("1,2,-2");
    		Calculator.add("-1,-2,-2");
    		Calculator.add("1,-2,-2");
    	}
    	catch (IllegalArgumentException e) {
    		System.out.println("Negatives not allowed: " + e);
    	}
    }

    @Test
    public void testNumbersBiggerThanOneThousand() {
    	assertEquals(2, Calculator.add("10011,2"));
    	assertEquals(5, Calculator.add("2\n3,1005"));
    	assertEquals(10, Calculator.add("5,5,10030"));
    	assertEquals(15, Calculator.add("4,11\n11111"));
    	assertEquals(1005, Calculator.add("1000,3,2"));
    }

    @Test
    public void testWithNewDelimeter() {
    	assertEquals(4, Calculator.add("//#\n2#2"));
    	assertEquals(3, Calculator.add("//&\n3&2"));
    	assertEquals(10, Calculator.add("//!!\n5!!5"));
    	assertEquals(7, Calculator.add("//M\n3M4"));
    }
}