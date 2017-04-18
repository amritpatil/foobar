package com.foo.bar.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.foo.bar.main.TradeAmount;

/**
 * 
 * Unit Test cases for calculating TradeAmount
 *
 */
public class TradeAmountTest {

	@Test
	public void testGetAmount() {
		TradeAmount tradeAmount = new TradeAmount();
	    assertEquals(10025, tradeAmount.getAmount("100.25", "200", ".5"), .000001);   
	    assertEquals(.00069, tradeAmount.getAmount(".345", "1", ".002"), .000001);   
	    assertEquals(0, tradeAmount.getAmount("200", "0", "-1"), .000001);   
	    assertEquals(0, tradeAmount.getAmount("300", "1", "0"), .000001);   
		    
		}
	
	
	/**
	 *  Test for Invalid Values
	 * 
	 */
	@Test(expected = NumberFormatException.class)
	public void testGetAmount1() {	
		
		TradeAmount tradeAmount = new TradeAmount();
		tradeAmount.getAmount("foo", "bar", "-1");
	}

}
