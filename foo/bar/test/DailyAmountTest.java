package com.foo.bar.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.foo.bar.main.DailyAmount;

public class DailyAmountTest {

	@Test
	public void testGetAmountIncoming() {
		DailyAmount dailyAmount = new DailyAmount();
		dailyAmount.setDailyAmountIncoming("02 Jan 2016", 200000.000);
		assertEquals(200000.000, dailyAmount.getAmountIncoming().get("02 Jan 2016").doubleValue(), 0.000001);
		dailyAmount.setDailyAmountIncoming("02 Jan 2016", 100000.000);
		assertEquals(300000.000, dailyAmount.getAmountIncoming().get("02 Jan 2016").doubleValue(), 0.000001);
		dailyAmount.setDailyAmountIncoming("03 Jan 2016", 5000.000);
		assertEquals(5000.000, dailyAmount.getAmountIncoming().get("03 Jan 2016").doubleValue(), 0.000001);

	}

	@Test
	public void testGetAmountOutgoing() {
		DailyAmount dailyAmount = new DailyAmount();
		dailyAmount.setDailyAmountOutgoing("02 Jan 2016", 200000.000);
		assertEquals(200000.000, dailyAmount.getAmountOutgoing().get("02 Jan 2016").doubleValue(), 0.000001);
		dailyAmount.setDailyAmountOutgoing("02 Jan 2016", 100000.000);
		assertEquals(300000.000, dailyAmount.getAmountOutgoing().get("02 Jan 2016").doubleValue(), 0.000001);
		dailyAmount.setDailyAmountOutgoing("03 Jan 2016", 5000.000);
		assertEquals(5000.000, dailyAmount.getAmountOutgoing().get("03 Jan 2016").doubleValue(), 0.000001);
	}

}
