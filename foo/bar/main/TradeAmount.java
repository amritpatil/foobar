package com.foo.bar.main;

/**
 * Calculates the total amount per trade - both outgoing and incoming
 *
 */
public class TradeAmount {

	private double amount;


	/**
	 * 
	 * Calculate Amount of a Trade - both outgoing and incoming
	 * 
	 * @param pricePerUnit
	 * @param units
	 * @param agreedFx
	 * @return
	 */
	public double getAmount(String pricePerUnit, String units, String agreedFx){
		return calculateAmount( pricePerUnit,  units,  agreedFx);
	}


	

	/**
	 * 
	 * Separate method for calculating amount in case 
	 * we change the way we calculate total trade amount
	 * 
	 * @param pricePerUnit
	 * @param units
	 * @param agreedFx
	 * @return Total Amount per trade
	 * @throws Currently throws NumberFormatException. Can be handled based on client requirement
	 * 
	 */
	private double calculateAmount (String pricePerUnit, String units, String agreedFx)  throws  NumberFormatException {
		
		amount= (Double.parseDouble(pricePerUnit)) * (Integer.parseInt(units)) * (Double.parseDouble(agreedFx)); 

		return amount;
	}
}