package com.foo.bar.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Calculates whether a day is a working day or holiday and also the next working day
 * 
 */
public class WorkDay {

	
	private boolean workday;
	
	/**
	 * Constants in case the currency symbols change
	 */
	private final String AED = "AED";
	private final String SAR = "SAR";
	private final String FORMATDATE = "dd MMM uuuu";	
	
	/**
	 * Constants in case we want to change which day is working and which day is a holiday
	 */
	private final String MONDAY = "Monday";
	private final String TUESDAY = "Tuesday";
	private final String WEDNESDAY = "Wednesday";
	private final String THURSDAY = "Thursday";
	private final String FRIDAY = "Friday";
	private final String SATURDAY = "Saturday";
	private final String SUNDAY = "Sunday";
	private final int  ONE = 1;
	private final int  TWO = 2;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATDATE, Locale.ENGLISH).withResolverStyle(ResolverStyle.STRICT);


	/**
	 * 
	 * Utility method that calculates whether a particular day is a working day
	 * or a holiday depending on date and currency
	 * 
	 * @param workingDay
	 * @param currency
	 * @return boolean
	 * @throws currently throw DateTimeParseException. Can be handled based on client requirement
	 */
	public boolean isWorkday(String workingDay , String currency) throws DateTimeParseException {


		LocalDate date = LocalDate.parse(workingDay, formatter);
		switch (date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH)) {
		case MONDAY:  
		case TUESDAY:  
		case WEDNESDAY:  
		case THURSDAY:   
			workday = true;
			break;
		case FRIDAY: 
			if (currency.equalsIgnoreCase(SAR) || currency.equalsIgnoreCase(AED))
				workday=false;
			else workday=true;

		case SATURDAY: 
			workday=false;
			break;
		case SUNDAY: 
			if (currency.equalsIgnoreCase(SAR) || currency.equalsIgnoreCase(AED))
				workday=true;
			else workday=false;
			break;
		} 

		return workday;
	}


	/**
	 * 
	 * Utility method that calculates the  
	 * next working day based on date and currency
	 * 
	 * @param workingDay
	 * @param currency
	 * @return Next Working day : date object
	 * @throws Currently throws DateTimeParseException. can be handled based on client requirement.
	 * 
	 */
	public LocalDate nextWorkingDay(String workingDay , String currency)  throws DateTimeParseException  {	
		LocalDate date = LocalDate.parse(workingDay, formatter);
			switch (date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH)) {

			case FRIDAY: 
				if (currency.equalsIgnoreCase(SAR) || currency.equalsIgnoreCase(AED))
					return date.plusDays(TWO);
				else return  date;

			case SATURDAY: 
				if (currency.equalsIgnoreCase(SAR) || currency.equalsIgnoreCase(AED))
					return date.plusDays(ONE);
				else return  date.plusDays(TWO);
			case SUNDAY: 
				if (currency.equalsIgnoreCase(SAR) || currency.equalsIgnoreCase(AED))
					return date;
				else 
					return date.plusDays(ONE);
			default: return date;

			}
	}
}