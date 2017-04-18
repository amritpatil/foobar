package com.foo.bar.main;

import java.util.Map;
import java.util.TreeMap;



/**
 * Calculates total incoming and outgoing Trade amounts and stores them in a TreeMap
 *
 */
public class DailyAmount {

	private Map<String, Double> multiMapInComing = new TreeMap<String,Double>();
	private Map<String, Double> multiMapOutGoing = new TreeMap<String,Double>();

	/**
	 * Calculates Total Daily Incoming Amount
	 * 
	 * @param settleDate
	 * @param amount
	 */
	public void setDailyAmountIncoming (String settleDate, Double amount) {

			if(multiMapInComing.containsKey(settleDate))
			{
				double old_amount=multiMapInComing.get(settleDate);
				multiMapInComing.put(settleDate, amount+old_amount);
			}
			else
				multiMapInComing.putIfAbsent(settleDate, amount);
		}

	
	/**
	 * Calculates Total Daily Outgoing Amount
	 * 
	 * @param settleDate
	 * @param amount
	 */
	public void setDailyAmountOutgoing (String settleDate, Double amount) {
	
			if(multiMapOutGoing.containsKey(settleDate))
			{
				double old_amount=multiMapOutGoing.get(settleDate);
				multiMapOutGoing.put(settleDate, amount+old_amount);
			}
			else
				multiMapOutGoing.putIfAbsent(settleDate, amount);
		}
	
	/**
	 * Returns Amount in USD settled incoming everyday
	 */
	public Map<String, Double> getAmountIncoming() {
		return multiMapInComing;
	}
	
	/**
	 * Returns Amount in USD settled outgoing everyday
	 */
	public Map<String, Double> getAmountOutgoing() {
		return multiMapOutGoing;
	}


}
