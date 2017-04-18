package com.foo.bar.test;

import static org.junit.Assert.*;
import java.time.*;
import java.time.format.DateTimeParseException;

import org.junit.Test;

import com.foo.bar.main.WorkDay;
public class WorkDayTest { 

	/**
	 * unit test cases to test work days, holidays, leap year
	 * 
	 */
	@Test
	public void testWorkingDay() {
		WorkDay workDay = new WorkDay();
		
		//assert false cases
		assertFalse(workDay.isWorkday("02 Jan 2016", "AED"));
		assertFalse(workDay.isWorkday("08 Jan 2016", "AED"));
		assertFalse(workDay.isWorkday("09 Jan 2016", "AED"));  
		assertFalse(workDay.isWorkday("28 Feb 2015", "AED"));
		
		//assert true cases
		assertTrue(workDay.isWorkday("03 Jan 2016", "AED"));   
		assertTrue(workDay.isWorkday("04 Jan 2016", "AED"));   
		assertTrue(workDay.isWorkday("05 Jan 2016", "AED"));   
		assertTrue(workDay.isWorkday("06 Jan 2016", "AED"));   
		assertTrue(workDay.isWorkday("07 Jan 2016", "AED"));   
		assertTrue(workDay.isWorkday("10 Jan 2016", "AED"));   
		assertTrue(workDay.isWorkday("28 Jan 2016", "AED"));

	}
	
	/**
	 * unit test case to test for Invalid days
	 * 
	 */
	@Test(expected = DateTimeParseException.class)
	public void testException() {	
		WorkDay workDay = new WorkDay();
		workDay.isWorkday("29 Feb 2015", "AED");
	}

	
	/**
	 * unit test case to test for Invalid days
	 * 
	 */
	@Test(expected = DateTimeParseException.class)
	public void testException1() {	
		WorkDay workDay = new WorkDay();
		workDay.isWorkday("34 Feb 2015", "AED");
	}
	
	/**
	 * unit test case to test for next working days, including February during leap year
	 * 
	 */
	@Test
	public void testNextworkingDay() {
		WorkDay workDay = new WorkDay();
		assertEquals(LocalDate.of(2016, Month.JANUARY, 10), workDay.nextWorkingDay("08 Jan 2016", "AED"));
		assertEquals(LocalDate.of(2016, Month.JANUARY, 10), workDay.nextWorkingDay("09 Jan 2016", "AED"));    
		assertEquals(LocalDate.of(2016, Month.JANUARY, 10), workDay.nextWorkingDay("08 Jan 2016", "SAR"));    
		assertEquals(LocalDate.of(2016, Month.JANUARY, 10), workDay.nextWorkingDay("09 Jan 2016", "SAR"));   
		assertEquals(LocalDate.of(2016, Month.JANUARY, 11), workDay.nextWorkingDay("09 Jan 2016", "USD"));  
		assertEquals(LocalDate.of(2016, Month.JANUARY, 11), workDay.nextWorkingDay("10 Jan 2016", "USD"));  
		assertEquals(LocalDate.of(2016, Month.JANUARY, 11), workDay.nextWorkingDay("10 Jan 2016", "INR"));


		assertEquals(LocalDate.of(2015, Month.MARCH, 01), workDay.nextWorkingDay("28 Feb 2015", "AED"));
		assertEquals(LocalDate.of(2016, Month.FEBRUARY, 28), workDay.nextWorkingDay("26 Feb 2016", "AED"));
		assertEquals(LocalDate.of(2016, Month.FEBRUARY, 28), workDay.nextWorkingDay("26 Feb 2016", "AED"));    
		assertEquals(LocalDate.of(2016, Month.FEBRUARY, 28), workDay.nextWorkingDay("26 Feb 2016", "SAR"));    
		assertEquals(LocalDate.of(2016, Month.FEBRUARY, 28), workDay.nextWorkingDay("26 Feb 2016", "SAR"));   
		assertEquals(LocalDate.of(2016, Month.FEBRUARY, 29), workDay.nextWorkingDay("27 Feb 2016", "USD"));  
		assertEquals(LocalDate.of(2016, Month.FEBRUARY, 29), workDay.nextWorkingDay("28 Feb 2016", "USD"));  
		assertEquals(LocalDate.of(2016, Month.FEBRUARY, 29), workDay.nextWorkingDay("28 Feb 2016", "INR"));		

		assertEquals(LocalDate.of(2015, Month.MARCH, 1), workDay.nextWorkingDay("27 Feb 2015", "AED"));
		assertEquals(LocalDate.of(2015, Month.MARCH, 1), workDay.nextWorkingDay("27 Feb 2015", "AED"));    
		assertEquals(LocalDate.of(2015, Month.MARCH, 1), workDay.nextWorkingDay("27 Feb 2015", "SAR"));    
		assertEquals(LocalDate.of(2015, Month.MARCH, 1), workDay.nextWorkingDay("27 Feb 2015", "SAR"));   
		assertEquals(LocalDate.of(2015, Month.MARCH, 2), workDay.nextWorkingDay("28 Feb 2015", "USD"));  
		assertEquals(LocalDate.of(2015, Month.MARCH, 2), workDay.nextWorkingDay("28 Feb 2015", "USD"));  
		assertEquals(LocalDate.of(2015, Month.MARCH, 2), workDay.nextWorkingDay("28 Feb 2015", "INR"));	

		assertEquals(LocalDate.of(2015, Month.MARCH, 2), workDay.nextWorkingDay("01 Mar 2015", "USD"));  
		assertEquals(LocalDate.of(2015, Month.MARCH, 2), workDay.nextWorkingDay("01 Mar 2015", "INR"));

	}


}
